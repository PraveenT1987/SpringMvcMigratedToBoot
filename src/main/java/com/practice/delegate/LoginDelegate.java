package com.practice.delegate;

import com.practice.bean.LoginBean;
import com.practice.database.DatabaseMock;

import java.util.Map;
import java.util.Set;

/**
 * Created by ravikiran_gorthi on 5/5/17.
 */
public class LoginDelegate {

    private LoginBean loginBean;
    private DatabaseMock databaseMock;
    private Map<String, String> userMap;
    private Set<String> userSet;

    public LoginDelegate(LoginBean loginBean) {
        this.loginBean = loginBean;
        this.databaseMock = new DatabaseMock();
        userMap = databaseMock.getUserDatabase();
        userSet = userMap.keySet();
    }

    public boolean isValidUser() {
        if(userSet.contains(this.loginBean.getUsername())) {
            return true;
        }
        return false;
    }

    public boolean validateCredentials() {
        if(loginBean.getPassword().equals(userMap.get(loginBean.getUsername()))) {
            return true;
        }
        else {
            return false;
        }
    }
}
