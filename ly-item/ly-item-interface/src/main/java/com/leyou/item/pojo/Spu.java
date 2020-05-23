package com.leyou.item.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tll
 * @date 2020/05/23
 */
@Data
@Table(name = "tb_spu")
public class Spu {
    /**
     * 自增
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private Long brandId;
    /**
     * 1级类目
     */
    private Long cid1;
    /**
     * 2级类目
     */
    private Long cid2;
    /**
     * 3级类目
     */
    private Long cid3;
    /**
     * 标题
     */
    private String title;
    /**
     * 子标题
     */
    private String subTitle;
    /**
     * 是否上架
     */
    private Boolean saleable;
    /**
     * 是否有效,逻辑除用
     * 不返回
     */
    @JsonIgnore
    private Boolean valid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    @JsonIgnore
    private Date lastUpdateTime;

    /**
     * 商品分类名称
     */
    @Transient
    private String cname;

    /**
     * 品牌名称
     */
    @Transient
    private String bname;

}