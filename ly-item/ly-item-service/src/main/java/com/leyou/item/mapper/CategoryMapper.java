package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author tll
 * @date 2020/05/12
 * IdListMapper<T,PK>  T- pojo PK - 主键类型
 */
public interface CategoryMapper extends Mapper<Category>, IdListMapper<Category,Long> {
}
