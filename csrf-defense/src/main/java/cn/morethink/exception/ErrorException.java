package cn.morethink.exception;

/**
 * @author 李文浩
 * @version 2017/4/10.
 */
public class ErrorException extends RuntimeException {
    private String error;

    public ErrorException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
