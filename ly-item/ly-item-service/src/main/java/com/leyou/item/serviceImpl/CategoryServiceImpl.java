package com.leyou.item.serviceImpl;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author tll
 * @date 2020/05/12
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     *自动注入通用mapper
     */
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryListByPid(Long pid) {
        //使用通用mapper进行查询
        Category t = new Category();
        t.setParentId(pid);
        //mapper会把对象中的非空字段作为查询条件进行查询
        List<Category> list = categoryMapper.select(t);
        //判断是否为空
        if (CollectionUtils.isEmpty(list)){
            //自定义异常捕获
            throw  new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }

    /**
     * 根据数据来查询分类
     * @param ids
     * @return
     */
    @Override
    public List<Category> queryByIds(List<Long> ids) {
        List<Category> categories = categoryMapper.selectByIdList(ids);

        if (CollectionUtils.isEmpty(categories)){
            //自定义异常捕获
            throw  new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return categories;
    }
}
