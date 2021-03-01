package com.mycx26.concurrency.firstresult;

/**
 * Created by mycx26 on 2020/11/3.
 */
public interface LoginValidator {

    boolean validate(String str, String password) throws Exception;
}
