package com.sumitaccess007;

import com.sumitaccess007.dao.EmployeeDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootJdbcModuleImplementationApplicationTests {

    @Autowired
    EmployeeDAO employeeDAO;

    @Test
    void shouldCreateCustomerAsSuccess() {
        boolean status = employeeDAO.createCustomer(1004,"Rahul","Mr.","Paris",2004);
        Assertions.assertTrue(status);
    }

    /*@Test
    void shouldDeleteCustomerByNameAsSuccess() {
        boolean status = employeeDAO.deleteCustomer("SSS");
        Assertions.assertTrue(status);

    }*/

    @Test
    void shouldDeleteCustomerByNameAsSucces(){
        boolean status = employeeDAO.deleteCustomer("Rahul");
        Assertions.assertTrue(status);
    }

    @Test
    void shouldDeleteCustomerByNameAsFailure() {
        boolean status = employeeDAO.deleteCustomer("SSS");
        Assertions.assertFalse(status);
    }
}
