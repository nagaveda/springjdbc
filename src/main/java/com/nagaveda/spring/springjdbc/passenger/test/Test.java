package com.nagaveda.spring.springjdbc.passenger.test;

import java.util.List;

import com.nagaveda.spring.springjdbc.passenger.dao.PassengerDao;
import com.nagaveda.spring.springjdbc.passenger.entity.Passenger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/nagaveda/spring/springjdbc/passenger/test/config.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
        // Passenger passenger = new Passenger();
        // passenger.setId(2);
        // passenger.setFirstName("Nagaveda");
        // passenger.setLastName("Reddy");
        // passengerDao.create(passenger);
        List<Passenger> passengers = passengerDao.readAll();
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
        // System.out.println("Fetched Passenger: " + passenger);
    }
}
