package com.leyou.item.serviceImpl;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/21 14:51
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

    /**
     * 通过分类id查询规格组信息
     * @param cid
     * @return
     */
    @Override
    public List<SpecGroup> queryGroupByCid(Long cid) {

        //通过通用Mapper来进行查询[是通过Object中已有的属性进行查询]
        SpecGroup group = new SpecGroup();
        group.setCid(cid);
        List<SpecGroup> list = specGroupMapper.select(group);
        if (CollectionUtils.isEmpty(list)){
            //没有查询到 抛出异常
            throw new LyException(ExceptionEnum.SPEC_GROUP_NOT_FOUND);
        }

        return list;
    }

    /**
     * 根据组id 查询规格信息
     * @param gid
     * @return
     */
    @Override
    public List<SpecParam> queryParamByGid(Long gid) {
        //查询条件
        SpecParam specParam = new SpecParam();
        specParam.setCid(gid);
        //通用mapper查询
        List<SpecParam> list = specParamMapper.select(specParam);

        //校验
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.SPEC_PARAM_NOT_FOUND);
        }
        return list;
    }

    /**
     * 新增规格参数
     * @param specGroup
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertGroups(SpecGroup specGroup) {
        int count = this.specGroupMapper.insert(specGroup);
        if (count != 1){
            //保存失败  抛出异常
            throw new LyException(ExceptionEnum.INSERT_GROUP_FAILURE);
        }

    }

    /**
     * 修改更新规格
     * @param specGroup
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateGroups(SpecGroup specGroup) {
        int count = this.specGroupMapper.updateByPrimaryKey(specGroup);
        if (count != 1){
            throw new LyException(ExceptionEnum.UPDATE_GROUP_FAILURE);
        }
    }

    /**
     * 删除规格
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteGroups(Long id) {
        SpecGroup group = new SpecGroup();
        group.setId(id);
        int count = this.specGroupMapper.delete(group);
        if (count != 1){
            throw new LyException(ExceptionEnum.DELETE_GROUP_FAILURE);
        }
    }


}
