package br.com.rodilon.rest_with_spring_boot_and_java.service;

import br.com.rodilon.rest_with_spring_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        logger.info("Finding all People!");
        for (int i = 0; i <= 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id) {

        logger.info("Finding one Person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Renan");
        person.setLastName("Odilon");
        person.setAddress("Guarulhos - Sao Paulo - Brasil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {

        logger.info("Creating one Person!");

        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id) {

        logger.info("Deleting one Person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male");
        return person;
    }
}
