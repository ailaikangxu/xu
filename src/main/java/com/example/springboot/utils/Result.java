package com.example.springboot.utils;

public class Result {

    private int code;
    private Object data;
    private String msg;

    public Result(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //包装
    public static Result success(Object data){
        return new Result(CODE.SUCCESS, data, "查询成功！");
    }
    public static Result error(String msg){
        return new Result(CODE.ERROR, null, msg);
    }
    public static Result error(int code,String msg){
        return new Result(code, null, msg);
    }
}
