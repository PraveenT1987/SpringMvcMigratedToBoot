package com.practice.dao;

import com.practice.bean.LoginBean;
import com.practice.exception.UnknownUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ravikiran_gorthi on 5/5/17.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;

    private boolean isValid, conStatus;
    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    public UserDaoImpl() {
    }


    @Override
    public boolean getConnectionStatus() {
        try(Connection con = dataSource.getConnection()) {
            conStatus = true;
        } catch (SQLException e) {
            conStatus = false;
            e.printStackTrace();
        }
        return conStatus;
    }

    @Override
    public boolean isValidUser(LoginBean loginBean) throws UnknownUserException {
        String user = loginBean.getUsername();
        try(Connection con = dataSource.getConnection()) {
            String sql = "select * from users where username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                isValid = true;
            }
            else {
                isValid = false;
                throw new UnknownUserException("User does not exist in Database!");
            }
        } catch (UnknownUserException | SQLException e) {
            isValid = false;
            log.error("Error Occurred while interacting with MySql Database");
            e.printStackTrace();
        }
        return isValid;
    }

    @Override
    public boolean checkUserCredentials(LoginBean loginBean) {
        String user = loginBean.getUsername();
        try(Connection con = dataSource.getConnection()) {
            String sql = "select username, userpwd from users where username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String pwd = rs.getString(2);
                if(pwd.equals(loginBean.getPassword())) {
                    isValid = true;
                }
                else {
                    isValid = false;
                    log.error("Incorrect User Password!");
                }
            }
        } catch (SQLException e) {
            isValid = false;
            log.error("Error Occurred while interacting with MySql Database");
            e.printStackTrace();
        }
        return isValid;
    }

}
