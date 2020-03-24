package ru.liga.intership.badcode.database;

import ru.liga.intership.badcode.domain.Person;
import ru.liga.intership.badcode.service.MyConverter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String CONNECTION_URL = "jdbc:hsqldb:mem:test";
    private String CONNECTION_USERNAME = "sa";
    private String CONNECTION_PASSWORD = "";
    private String QUERY = "SELECT * FROM person WHERE sex = 'male' AND age > 18";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Database() {
        this.connection = getConnectionToDB();
        this.statement = getStatement();
        this.resultSet = getResultSet();
    }

    public Connection getConnectionToDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
            statement = conn.createStatement();
            System.out.println("Application connected to DB");
        } catch (SQLException e) {
            System.out.println("No connection to DB");
            e.printStackTrace();
        }
        return conn;
    }

    private Statement getStatement() {
        Statement stat = null;
        try {
            stat = connection.createStatement();
            System.out.println("Application created statement");
        } catch (SQLException e) {
            System.out.println("Statement doesn't created");
            e.printStackTrace();
        }
        return stat;
    }

    public ResultSet getResultSet() {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(QUERY);
            System.out.println("Executing query is successful");
        } catch (SQLException e) {
            System.out.println("Query faild");
            e.printStackTrace();
        }
        return rs;
    }

    public List<Person> getConvertedPersonsFromDB(){
        List<Person> persons = MyConverter.convertResultSetToArrayList(resultSet);
        return persons;
    }




}
