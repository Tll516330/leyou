package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author tll
 * @date 2020/05/15
 * 定义一个枚举
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    /**
     * 异常参数
     */
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(404,"商品分类没查到"),
    BRAND_NOT_FOUND(404,"品牌分类为查到"),
    BRAND_SAVE_ERROR(500,"新增品牌失败"),
    UPLOAD_FILE_ERROR(500,"上传文件失败"),
    INVALID_FILE_TYPE(500,"无效文件类型"),
    SPEC_GROUP_NOT_FOUND(404,"规格组没有查询到"),
    SPEC_PARAM_NOT_FOUND(404,"规格参数没有查询到"),
    INSERT_GROUP_FAILURE(404,"新增规格组失败"),
    UPDATE_GROUP_FAILURE(404,"修改更新规格组失败"),
    DELETE_GROUP_FAILURE(404,"删除规格组失败"),
    GOODS_NOT_FOUND(404,"商品未查询到")
    ;
    private int code;
    private String msg;
}
