package com.nagaveda.spring.springjdbc.employee.test;

import java.util.List;

import com.nagaveda.spring.springjdbc.employee.dao.EmployeeDao;
import com.nagaveda.spring.springjdbc.employee.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/nagaveda/spring/springjdbc/employee/test/config.xml");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        // Employee emp = new Employee();
        // emp.setId(5);
        // emp.setFirstName("Virat");
        // emp.setLastName("Kohli");
        // int res = employeeDao.create(emp);
        // int res = employeeDao.update(emp);
        // int res = employeeDao.delete(5);
        List<Employee> employees = employeeDao.readAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
