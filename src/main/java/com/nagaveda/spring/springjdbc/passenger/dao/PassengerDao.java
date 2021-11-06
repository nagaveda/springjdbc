package com.nagaveda.spring.springjdbc.passenger.dao;

import java.util.List;

import com.nagaveda.spring.springjdbc.passenger.entity.Passenger;

public interface PassengerDao {
    int create(Passenger passenger);

    int update(Passenger passenger);

    int delete(int id);

    Passenger read(int id);

    List<Passenger> readAll();

}
