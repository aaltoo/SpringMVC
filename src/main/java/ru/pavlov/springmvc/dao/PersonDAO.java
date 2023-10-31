package ru.pavlov.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.pavlov.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(1, "Tom"));
        people.add(new Person(2, "John"));
        people.add(new Person(3, "Mary"));
        people.add(new Person(4, "Alessia"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
