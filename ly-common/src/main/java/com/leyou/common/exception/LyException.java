package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author tll
 * @date 2020/05/15
 * 继承异常  自定义通用异常方法
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LyException extends RuntimeException{

    private ExceptionEnum exceptionEnum;

}
