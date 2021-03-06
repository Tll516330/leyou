package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author tll
 * @date 2020/5/12
 */
public interface CategoryService {
    /**
     * 根据父节点查询商品分类
     * @param pid
     * @return
     */
    List<Category> queryCategoryListByPid(Long pid);

    /**
     * 根据数据查询分类信息List
     * @param ids
     * @return
     */
    List<Category> queryByIds(List<Long> ids);
}
