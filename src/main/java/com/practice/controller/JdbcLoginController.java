package com.practice.controller;

import com.practice.bean.LoginBean;
import com.practice.exception.UnknownUserException;
import com.practice.service.UserService;
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
public class JdbcLoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/jdbcLogin", method = RequestMethod.POST)
    public ModelAndView executeJdbcLogin(@ModelAttribute("loginBean") LoginBean loginBean) {
        ModelAndView model = new ModelAndView();
        System.out.println(loginBean);
        try {
            boolean isValidUser = userService.isValidUser(loginBean);

            System.out.println("Result = "+isValidUser);
            if (isValidUser) {
                if (userService.checkUserCredentials(loginBean)) {
                    model.addObject("loginBean", loginBean);
                } else {
                    model.addObject("jdbcMessage", "Invalid User Credentials !");
                }
            } else {
                model.addObject("jdbcMessage", "User Not found in Database !");
            }
        } catch (UnknownUserException e) {
            e.printStackTrace();
        }

        model.setViewName("index");
        return model;
    }

}