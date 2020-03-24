package ru.liga.intership.badcode.service;

import ru.liga.intership.badcode.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyConverter {

    public static List<Person> convertResultSetToArrayList(ResultSet resultSet) {
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
            System.out.println("Result Set converted to arraylist");
        } catch (SQLException e) {
            System.out.println("Cannot write from db to arraylist");
            e.printStackTrace();
        }
        return adultPersons;
    }

}
