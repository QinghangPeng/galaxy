package com.guide.galaxy.error;

/**
 * @ClassName: GlobalException
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-11-28 17:19
 * @Version: 1.0
 **/
public class GlobalException extends RuntimeException {

    private GlobalErrors error;

    public GlobalException(GlobalErrors error) {
        super(error.getValue());
    }

    public GlobalException(GlobalErrors error,String message) {
        super(error.getValue() + message);
    }

    public GlobalErrors getError() {
        return error;
    }
}
