package com.xxl.job.executor.result;

public enum ResultCode {

    successCode(200,"成功"),
    businErrorCode(201,"业务异常"),
    SystemErrorCode(202,"系统异常"),
    SystemTimeOutCode(203,"系统超时熔断");

    private int code;
    private String msg;

    private ResultCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
