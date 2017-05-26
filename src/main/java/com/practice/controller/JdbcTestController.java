package com.practice.controller;

import com.practice.bean.LoginBean;
import com.practice.dao.UserDao;
import com.practice.delegate.LoginDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ravikiran_gorthi on 5/4/17.
 */

@Controller
public class JdbcTestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/jdbcTest", method= RequestMethod.GET)
    public ModelAndView checkJdbcConnection()
    {
        ModelAndView model = new ModelAndView();

        if(userDao.getConnectionStatus()) {
            model.addObject("jdbcTestResult", "success");
        } else {
            model.addObject("jdbcTestResult", "failed");
        }
        model.setViewName("jdbcTest");

        return model;
    }

}