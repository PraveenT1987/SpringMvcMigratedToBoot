package com.practice.dao;

import com.practice.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ravikiran_gorthi on 5/9/17.
 */
public class DaoTest {

    public static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/practicedb");
        dataSource.setUsername("root");
        dataSource.setPassword("nisum");

        return dataSource;
    }

    public static void main (String[] args) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

        String sql = "SELECT * FROM customer";
//        List<Customer> customerList = jdbcTemplate.query(sql, new RowMapper<Customer>() {
//
//            @Override
//            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Customer customer = new Customer();
//
//                customer.setCustomerId(rs.getInt("customer_id"));
//                customer.setFirstName(rs.getString("first_name"));
//                customer.setLastName(rs.getString("last_name"));
//                customer.setEmailId(rs.getString("email_id"));
//                customer.setMobileNo(rs.getLong("mobile_no"));
//
//                return customer;
//            }
//
//        });
//
//        System.out.println("Found "+customerList.size()+" customers");
//        for (Customer customer : customerList) {
//            System.out.println(customer);
//        }
    }

}
