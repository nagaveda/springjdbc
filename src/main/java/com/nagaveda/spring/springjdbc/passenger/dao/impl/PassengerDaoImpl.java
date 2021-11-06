package com.nagaveda.spring.springjdbc.passenger.dao.impl;

import java.util.List;

import com.nagaveda.spring.springjdbc.passenger.dao.PassengerDao;
import com.nagaveda.spring.springjdbc.passenger.dao.impl.rowmapper.PassengerRowMapper;
import com.nagaveda.spring.springjdbc.passenger.entity.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Passenger passenger) {
        String sql = "insert into passenger values(?, ?, ?);";
        int res = jdbcTemplate.update(sql, passenger.getId(), passenger.getFirstName(), passenger.getLastName());
        return res;
    }

    @Override
    public int update(Passenger passenger) {
        String sql = "update passenger set firstname = ?, lastname = ? where id=?;";
        int res = jdbcTemplate.update(sql, passenger.getFirstName(), passenger.getLastName(), passenger.getId());
        return res;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from passenger where id=?;";
        int res = jdbcTemplate.update(sql, id);
        return res;
    }

    @Override
    public Passenger read(int id) {
        String sql = "select * from passenger where id = ?;";
        PassengerRowMapper rowMapper = new PassengerRowMapper();
        Passenger passenger = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return passenger;
    }

    @Override
    public List<Passenger> readAll() {
        String sql = "select * from passenger;";
        PassengerRowMapper rowMapper = new PassengerRowMapper();
        List<Passenger> passengers = jdbcTemplate.query(sql, rowMapper);
        return passengers;
    }

}
