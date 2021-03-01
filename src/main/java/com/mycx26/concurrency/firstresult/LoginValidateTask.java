package com.mycx26.concurrency.firstresult;

import com.mycx26.concurrency.exception.AppException;

import java.util.concurrent.Callable;

/**
 * Created by mycx26 on 2020/11/3.
 */
public class LoginValidateTask implements Callable<String> {

    private LoginValidator loginValidator;

    private String str;

    private String password;

    public LoginValidateTask(LoginValidator loginValidator, String str, String password) {
        this.loginValidator = loginValidator;

        this.str = str;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        String type = null;
        if (loginValidator instanceof UsernameValidator) {
            type = "username";
        } else if (loginValidator instanceof EmailValidator) {
            type = "email";
        } else if (loginValidator instanceof MobileValidator) {
            type = "mobile";
        }

        if (!loginValidator.validate(str, password)) {
            System.out.println("validate by " + type + " failure");
            throw new AppException("validate by " + type + " failure");
        }

        System.out.println("validate by " + type + " success");
        return "success";
    }
}
