package com.alperbasak.employeemanagement.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3,max = 50)
    @Column(name = "FIRST_NAME",nullable = false)
    private String firstName;

    @Size(min = 3,max = 50)
    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "JOINING_DATE",nullable = false)
    private LocalDate joiningDate;

    @NotNull
    @Digits(integer = 8,fraction = 2)
    @Column(name = "SALARY",nullable = false)
    private BigDecimal salary;

    @Digits(integer = 3,fraction = 2)
    @Column(name = "COMMISSION_PRC",nullable = true)
    private BigDecimal commissionPrc;

    @NotEmpty
    @Column(name = "PHONE_NUMBER",unique = true,nullable = false)
    private String phoneNumber;

    @NotEmpty
    @Column(name = "EMAIL",unique = true,nullable = false)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPrc() {
        return commissionPrc;
    }

    public void setCommissionPrc(BigDecimal commissionPrc) {
        this.commissionPrc = commissionPrc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
