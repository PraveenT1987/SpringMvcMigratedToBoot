package com.practice.bean;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by ravikiran_gorthi on 5/8/17.
 */
public class Customer {

    private int customerId;

    @NotNull(message = "First Name can not be null ... ")
    private String firstName;

    @NotNull(message = "Last Name can not be null ... ")
    private String lastName;

    @NotNull(message = "Email Id can not be null ... ")
    @Email(message = "Invalid email id")
    private String emailId;

    @NotNull(message = "Mobile No. can not be null ... ")
    @Digits(integer = 10, fraction = 0, message = "Mobile No. can not be more than 10 digits")
    private long mobileNo;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String emailId, long mobileNo, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
