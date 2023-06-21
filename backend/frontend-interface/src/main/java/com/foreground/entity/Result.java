package com.foreground.entity;

public class Result {
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "Result{msg = " + msg + ", data = " + data + "}";
    }

    public void setMsgAndData(String msg,Object data){
        this.msg = msg;
        this.data = data;
    }
}
