package ru.liga.intership.badcode.service;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import static org.junit.Assert.*;

import org.springframework.boot.SpringApplication;
import ru.liga.intership.badcode.BadcodeApplication;
import ru.liga.intership.badcode.database.Database;


public class DatabaseTests {

    private Database database;

    @Before
    public void init() {
        SpringApplication.run(BadcodeApplication.class);
        database = new Database();
    }

    @Test
    public void whenDatabaseIsNotEmpty(){
        assertNotNull(database.getConnectionToDB());
    }

    @Test
    public void whenCountOfColumnInResultSetIsTrue() throws SQLException {
        assertEquals(database.getResultSet().getMetaData().getColumnCount(), 6);
    }

    @Test
    public void whenCountOfPersonsInFinalArrayIsTrue() {
        assertEquals(database.getConvertedPersonsFromDB().size(), 2);
    }

}
