package com.nagaveda.spring.springjdbc.employee.dao.impl;

import java.util.List;

import com.nagaveda.spring.springjdbc.employee.dao.EmployeeDao;
import com.nagaveda.spring.springjdbc.employee.dao.rowmapper.EmployeeRowMapper;
import com.nagaveda.spring.springjdbc.employee.dto.Employee;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(Employee employee) {
        String sql = "insert into employee values(?, ?, ?);";
        int result = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
        return result;
    }

    @Override
    public int update(Employee employee) {
        String sql = "update employee set firstname=?, lastname=? where id=?;";
        int result = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
        return result;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from employee where id=?;";
        int result = jdbcTemplate.update(sql, id);
        return result;
    }

    @Override
    public Employee read(int id) {
        String sql = "select * from employee where id = ?";
        EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
        Employee resEmp = jdbcTemplate.queryForObject(sql, employeeRowMapper, id);
        return resEmp;

    }

    @Override
    public List<Employee> readAll() {
        String sql = "select * from employee";
        EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
        List<Employee> res = jdbcTemplate.query(sql, employeeRowMapper);
        return res;
    }

}
