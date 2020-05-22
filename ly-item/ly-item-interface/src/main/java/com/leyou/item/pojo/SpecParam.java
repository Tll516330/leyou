package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/21 15:57
 */
@Data
@Table(name = "tb_spec_param")
public class SpecParam {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private Long cid;

    private Long groupId;

    private String name;

    @Column(name = "numeric")
    private Boolean numeric;

    private String unit;

    private Boolean generic;

    private Boolean searching;

    private String segments;

}
