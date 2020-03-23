package ru.liga.intership.badcode.database;

import ru.liga.intership.badcode.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final String CONNECTION_URL = "jdbc:hsqldb:mem:test";
    private final String CONNECTION_USERNAME = "sa";
    private final String CONNECTION_PASSWORD = "";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Database() {
        this.connection = getConnectionToDB();
        this.statement = getStatement();
        this.resultSet = getResultSet();
    }

    private ResultSet getResultSet() {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM person WHERE sex = 'male' AND age > 18");
        } catch (SQLException e) {
            System.out.println("Query faild");
            e.printStackTrace();
        }
        return rs;
    }

    private Statement getStatement() {
        Statement stat = null;
        try {
            stat = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Statement doesn't created");
            e.printStackTrace();
        }
        return stat;
    }

    private Connection getConnectionToDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
        } catch (SQLException e) {
            System.out.println("No connection to DB");
            e.printStackTrace();
        }
        return conn;
    }

    public List<Person> getPersonsFromDB(){
        List<Person> persons = convertResultSetToArrayList();
        return persons;
    }

    private List<Person> convertResultSetToArrayList() {
        List<Person> adultPersons = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Person p = new Person();
                //Retrieve by column name
                p.setId(resultSet.getLong("id"))
                        .setSex(resultSet.getString("sex"))
                        .setName(resultSet.getString("name"))
                        .setAge(resultSet.getLong("age"))
                        .setWeight(resultSet.getLong("weight"))
                        .setHeight(resultSet.getLong("height"));
                adultPersons.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Cannot write from db to arraylist");
            e.printStackTrace();
        }
        return adultPersons;
    }


}
