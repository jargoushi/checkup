package com.devise.checkup.exception;

public class BizException extends RuntimeException{

    private String code;

    private String msg;

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }


}