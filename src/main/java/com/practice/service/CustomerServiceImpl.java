package com.practice.service;

import com.practice.bean.Customer;
import com.practice.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ravikiran_gorthi on 5/8/17.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    private boolean customerDeleted;

    @Override
    public void saveOrUpdate(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public Customer getCustomer(int customerId) {
        return customerDao.getCustomer(customerId);
    }

    @Override
    public List<Customer> listCustomer() {
        return customerDao.listCustomer();
    }

    @Override
    public boolean isCustomerDeleted() {
        return customerDao.isCustomerDeleted();
    }

    @Override
    public boolean isCustomerUpdated() {
        return customerDao.isCustomerUpdated();
    }
}
