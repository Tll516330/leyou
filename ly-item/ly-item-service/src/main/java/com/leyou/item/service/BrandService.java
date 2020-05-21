package com.leyou.item.service;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;

/**
 * @author tll
 * @date 2020/05/18
 */
public interface BrandService {
    /**
     * 根据条件查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key);

    /**
     * 保存新增品牌信息
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);
}
