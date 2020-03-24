package ru.liga.intership.badcode.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.Assert.*;

import ru.liga.intership.badcode.BadcodeApplication;
import ru.liga.intership.badcode.database.Database;

public class PersonServiceTests {

    private Database database;
    private PersonService personService;

    @Before
    public void init() {
        SpringApplication.run(BadcodeApplication.class);
        personService = new PersonService();
        database = new Database();
    }

    @Test
    public void whenTotalImtIsTrue() {
        assertEquals((long) personService.getTotalImt(database.getConvertedPersonsFromDB()), (long) 51.54841992198541);
    }

}
