package com.sumitaccess007.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class EmployeeDAO {
    JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public boolean createCustomer(int Cnum, String Lname, String Salutation, String city, int Snum){
        return jdbcTemplate.update("Insert into customers (Cnum,Lname,Salutation,city,Snum) values (?,?,?,?,?)", preparedStatement -> {
            preparedStatement.setInt(1,Cnum);
            preparedStatement.setString(2,Lname);
            preparedStatement.setString(3,Salutation);
            preparedStatement.setString(4,city);
            preparedStatement.setInt(5,Snum);
        }) > 0;
    }

    public boolean deleteCustomer(String Lname){
        return jdbcTemplate.update("Delete from customers where Lname=?",preparedStatement -> {
            preparedStatement.setString(1,Lname);
        }) > 0;
    }
}
