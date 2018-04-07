package cn.morethink.util;

/**
 * 返回结果
 *
 * @author 李文浩
 * @version 2017/4/6.
 */
public class Result {
    private String status;
    private Object message;
    private Object data;
    public Result() {
    }

    public Result(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
