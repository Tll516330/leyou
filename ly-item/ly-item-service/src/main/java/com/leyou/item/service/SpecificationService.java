package com.leyou.item.service;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;

import java.util.List;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/21 14:51
 */
public interface SpecificationService {

    /**
     * 通过分类id查询规格组信息
     * @param
     * @return
     */
    List<SpecGroup> queryGroupByCid(Long cid);


    /**
     * 根据组id查询规格参数
     * @param gid
     * @return
     */
    List<SpecParam> queryParamByGid(Long gid);

    /**
     * 新增规格组
     * @param specGroup
     */
    void insertGroups(SpecGroup specGroup);

    /**
     * 修改更新规格组
     * @param specGroup
     */
    void updateGroups(SpecGroup specGroup);

    /**
     * 删除规格组
     * @param id
     */
    void deleteGroups(Long id);
}
