package com.leyou.item.service;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Spu;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/23 13:52
 */
public interface GoodsService {

    /**
     * 查询商品
     * @param page
     * @param rows
     * @param saleable
     * @param key
     * @return
     */
    PageResult<Spu> querySpuByPage(Integer page, Integer rows, Boolean saleable, String key);

}
