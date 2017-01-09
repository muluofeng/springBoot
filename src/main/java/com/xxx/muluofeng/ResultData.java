package com.xxx.muluofeng;

/**
 * Created by Administrator on 2016/12/27.
 */
public class ResultData<T> {
    private String message;
    private Boolean success;
    private T data;
    public ResultData(){

    }
    public ResultData(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
