package com.practice.dao;

import com.practice.bean.LoginBean;
import com.practice.exception.UnknownUserException;

/**
 * Created by ravikiran_gorthi on 5/5/17.
 */

public interface UserDao {

    public boolean getConnectionStatus();

    public boolean isValidUser(LoginBean loginBean) throws UnknownUserException;

    public boolean checkUserCredentials(LoginBean loginBean);

}
