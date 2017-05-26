package com.practice.dao;

import com.practice.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ravikiran_gorthi on 5/8/17.
 */

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;
    private boolean isCustomerDeleted, isCustomerUpdated;

    @Override
    public void saveOrUpdate(Customer customer) {
        int result = 0;
        if (customer.getCustomerId() > 0) {
            // update
            String sql = "UPDATE customer SET first_name = ?, last_name = ?, email_id = ?, mobile_no = ? "
                    + "WHERE customer_id = ?";

            result = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(),
                    customer.getEmailId(), customer.getMobileNo(), customer.getCustomerId());
        } else {
            // insert
            String sql = "INSERT INTO customer (first_name, last_name, email_id, mobile_no)"
                    + " VALUES (?, ?, ?, ?)";
            result = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(),
                    customer.getEmailId(), customer.getMobileNo());
        }

        if(result > 0) {
            this.isCustomerUpdated = true;
        } else {
            this.isCustomerUpdated = false;
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM customer WHERE customer_id=?";

        int result = jdbcTemplate.update(sql, customerId);
        if(result > 0) {
            this.isCustomerDeleted = true;
        } else {
            this.isCustomerDeleted = false;
        }
    }

    @Override
    public Customer getCustomer(int customerId) {
        String sql = "SELECT * FROM customer WHERE customer_id=" + customerId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return processData(rs);
                }

                return null;
            }

        });
    }

    @Override
    public List<Customer> listCustomer() {
        String sql = "SELECT * FROM customer";
        List<Customer> listCustomer = jdbcTemplate.query(sql, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return processData(rs);
            }

        });

        return listCustomer;
    }

    public Customer processData(ResultSet rs) throws SQLException, DataAccessException {

        Customer customer = new Customer();

        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmailId(rs.getString("email_id"));
        customer.setMobileNo(rs.getLong("mobile_no"));

        return customer;
    }

    @Override
    public boolean isCustomerDeleted() {
        return isCustomerDeleted;
    }

    @Override
    public boolean isCustomerUpdated() { return isCustomerUpdated; }
}
