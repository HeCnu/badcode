package ru.liga.intership.badcode.service;


import ru.liga.intership.badcode.database.Database;
import ru.liga.intership.badcode.domain.Person;
import java.util.List;

public class PersonService {


    /**
     * Возвращает средний индекс массы тела всех лиц мужского пола старше 18 лет
     *
     * @return
     */
    public void getAdultMaleUsersAverageBMI() {
        Database database = new Database();
        List<Person> adultPersons = database.getConvertedPersonsFromDB();
        double totalImt = getTotalImt(adultPersons);
        long countOfPerson = adultPersons.size();

        System.out.println("Average imt - " + totalImt / countOfPerson);
    }

    public double getTotalImt(List<Person> adultPersons) {
        double totalImt = 0.0;
        for (Person p : adultPersons) {
            double heightInMeters = getHeightInMeters(p);
            double imt = getImt(p, heightInMeters);
            totalImt += imt;
        }
        return totalImt;
    }

    private double getImt(Person p, double heightInMeters) {
        return p.getWeight() / (Double) (heightInMeters * heightInMeters);
    }

    private double getHeightInMeters(Person p) {
        return p.getHeight() / 100d;
    }

}
