package com.practice.controller;

import com.practice.bean.Customer;
import com.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by ravikiran_gorthi on 5/4/17.
 */

@Controller
public class JdbcCrudController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/jdbcCrudPage", method = RequestMethod.GET)
    public ModelAndView showJdbcCrudPage(ModelAndView model, @ModelAttribute("customer") Customer customer) {

        model.addObject("customer", new Customer());
        model.addObject("listCustomer", customerService.listCustomer());
        model.addObject("jdbcCrudMessage", null);
        model.setViewName("jdbcCrud");

        return model;
    }

    @RequestMapping(value = "/jdbcCrudShow", method = RequestMethod.GET)
    public ModelAndView redirectToJdbcCrudPage(ModelAndView model, @ModelAttribute("customer") Customer customer) {
        model.addObject("customer", new Customer());
        model.addObject("listCustomer", customerService.listCustomer());
        model.addObject("jdbcCustomer", "Show");
        model.addObject("jdbcCrudMessage", null);
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = {"/saveCustomer", "editCustomer/saveCustomer"}, method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result,
                               Model model) {
        customerService.saveOrUpdate(customer);
        if (!customerService.isCustomerUpdated()) {
            model = getDefaultJdbcModel(model);
            model.addAttribute("jdbcCrudMessage", "Unable to save/update the Customer with Id " + customer.getCustomerId() + "!");
            model.addAttribute("errors", result);

            return "index";
        }

        return "redirect:/jdbcCrudShow";
    }

    @RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable("customerId") int customerId, Model model) {
        customerService.deleteCustomer(customerId);

        if (!customerService.isCustomerDeleted()) {
            model = getDefaultJdbcModel(model);
            model.addAttribute("jdbcCrudMessage", "Unable to Delete the Customer with Id " + customerId + "!");
            return "index";
        }

        return "redirect:/jdbcCrudShow";
    }

    @RequestMapping(value = "/editCustomer/{customerId}", method = RequestMethod.GET)
    public String editCustomer(@PathVariable("customerId") int customerId, Model model) {
        model = getDefaultJdbcModel(model);
        model.addAttribute("customer", customerService.getCustomer(customerId));

        return "index";
    }

    private Model getDefaultJdbcModel(Model model) {

        model.addAttribute("jdbcCustomer", "Show");
        model.addAttribute("listCustomer", customerService.listCustomer());

        return model;
    }

}