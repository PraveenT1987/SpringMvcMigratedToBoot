package com.practice.controller;

import com.practice.bean.LoginBean;
import com.practice.delegate.LoginDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ravikiran_gorthi on 5/4/17.
 */

@Controller
public class LoginController {

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ModelAndView executeLogin(@ModelAttribute("loginBean") LoginBean loginBean)
    {
        ModelAndView model = new ModelAndView();
        System.out.println(loginBean);
        LoginDelegate loginDelegate = new LoginDelegate(loginBean);
        if(loginDelegate.isValidUser()) {
            if (loginDelegate.validateCredentials()) {
                model.addObject("loginBean", loginBean);
            } else {
                model.addObject("message", "Invalid User Credentials !");
            }
        } else {
            model.addObject("message", "User Not found in Database !");
        }

        model.setViewName("index");
        return model;
    }

}