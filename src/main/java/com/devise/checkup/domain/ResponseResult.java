package com.devise.checkup.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Data
@ToString
public class ResponseResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;
}
