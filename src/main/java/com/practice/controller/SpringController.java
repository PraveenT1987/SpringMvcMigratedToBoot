package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ravikiran_gorthi on 5/4/17.
 */

@Controller
public class SpringController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initalPage() {
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String backToInitalPage() {
        return "index";
    }

    @RequestMapping(value = "/springCheck", method = RequestMethod.GET)
    public ModelAndView springEndpoint() {
        ModelAndView model = new ModelAndView();
        model.addObject("springCheckResult", "Hey ! Your Spring Setup is Good.");
        model.setViewName("springCheck");

        return model;
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/jdbcLoginPage", method = RequestMethod.GET)
    public String goToJdbcLoginPage() {
        return "jdbcLogin";
    }

}