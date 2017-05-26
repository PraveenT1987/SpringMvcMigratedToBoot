package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/")
	@ResponseBody
    public String firstPage() {
		return "Hey, You have successfully deployed your Spring Boot Demo" +
                "<br><br>" +
                "<a href='./welcome.html'>Welcome Click Here</a>";
	}

	@RequestMapping("/welcome.html")
    public ModelAndView welcomePage() {
		return new ModelAndView("welcome");
	}

}