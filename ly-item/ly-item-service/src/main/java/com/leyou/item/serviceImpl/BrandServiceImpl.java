package com.leyou.item.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author tll
 * @date 2020/05/18
 * 业务层
 */
@Service
public class BrandServiceImpl implements BrandService {

    /**
     *
     * 自动注入通用Mapper
     */
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 根据条件进行查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @Override
    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //分页   查询第几页  每页多少行数据
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)){
            //过滤条件
            example.createCriteria().orLike("name","%"+key+"%")
                    .orEqualTo("letter",key.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)){
            //三元运算符
            String orderByClause = sortBy + (desc ? " DESC " : " ASC ");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<Brand> list = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            throw  new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //解析分页结果
        PageInfo<Brand> info = new PageInfo<>(list);

        return new PageResult<>(info.getTotal(),list);
    }

    /**
     * 保存新增品牌分类
     * 不仅仅需要保存新增品牌  还要维护品牌和商品分类的中间表
     * 一个分类下 有很多个品牌
     * 手机 =》 [苹果,小米,华为,一加]
     *
     * 在日常事务中如果失败一定要回滚 Rollback
     *
     * @param brand
     * @param cids
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBrand(Brand brand, List<Long> cids) {
        //新增品牌信息
        brand.setId(null);
        int count = this.brandMapper.insert(brand);
        if (count != 1){
            //数据添加失败
            throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
        }
        //新增品牌和分类中间表
        for (Long cid : cids) {
            //没有中间表实体类  所以需要自定义sql
            count = this.brandMapper.insertCategoryBrand(cid, brand.getId());
            if (count != 1){
                throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
            }
        }
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @Override
    public Brand queryById(Long id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        if (brand == null){
            throw  new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        return brand;
    }
}
