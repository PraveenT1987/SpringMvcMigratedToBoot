package com.practice.service;

import com.practice.bean.LoginBean;
import com.practice.dao.UserDao;
import com.practice.dao.UserDaoImpl;
import com.practice.exception.UnknownUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ravikiran_gorthi on 5/5/17.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private boolean isValid, conStatus;
    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    public UserServiceImpl() {

    }

    public boolean getConnectionStatus() {
        return userDao.getConnectionStatus();
    }

    @Override
    public boolean isValidUser(LoginBean loginBean) throws UnknownUserException {
        return userDao.isValidUser(loginBean);
    }

    @Override
    public boolean checkUserCredentials(LoginBean loginBean) {
        return userDao.checkUserCredentials(loginBean);
    }
}
