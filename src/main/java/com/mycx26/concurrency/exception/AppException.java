package com.mycx26.concurrency.exception;

/**
 * Custom base exception for app.
 *
 * Created by mycx26 on 2020/2/26.
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = -2380348913209748827L;

    public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }

    // isI18n, avoid compiler confuse constructor
//    public AppException(boolean isI18n, String code, Object... args) {
//        super(MessageUtil.message(code, args));
//    }
}
