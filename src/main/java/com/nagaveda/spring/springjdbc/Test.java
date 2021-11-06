package com.nagaveda.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/nagaveda/spring/springjdbc/config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "insert into employee values(?,?,?);";
        int x = jdbcTemplate.update(sql, 2, "Nagaveda", "Reddy");
        System.out.println("Records updated: " + x);
    }
}
