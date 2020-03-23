package ru.liga.intership.badcode.service;


import ru.liga.intership.badcode.database.Database;
import ru.liga.intership.badcode.domain.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonService {


    /**
     * Возвращает средний индекс массы тела всех лиц мужского пола старше 18 лет
     *
     * @return
     */
    public void getAdultMaleUsersAverageBMI() {
        double totalImt = 0.0;
        long countOfPerson = 0;
        Database database = new Database();
        List<Person> adultPersons = database.getPersonsFromDB();
        for (Person p : adultPersons) {
            double heightInMeters = p.getHeight() / 100d;
            double imt = p.getWeight() / (Double) (heightInMeters * heightInMeters);
            totalImt += imt;
        }
        countOfPerson = adultPersons.size();

        System.out.println("Average imt - " + totalImt / countOfPerson);
    }

}
