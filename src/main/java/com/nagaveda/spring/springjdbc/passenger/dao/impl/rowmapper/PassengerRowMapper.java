package com.nagaveda.spring.springjdbc.passenger.dao.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nagaveda.spring.springjdbc.passenger.entity.Passenger;

import org.springframework.jdbc.core.RowMapper;

public class PassengerRowMapper implements RowMapper<Passenger> {

    @Override
    public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
        Passenger passenger = new Passenger();
        passenger.setId(rs.getInt(1));
        passenger.setFirstName(rs.getString(2));
        passenger.setLastName(rs.getString(3));
        return passenger;
    }

}
