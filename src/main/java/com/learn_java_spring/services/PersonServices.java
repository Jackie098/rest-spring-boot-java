package com.learn_java_spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.learn_java_spring.models.Person;

@Service
public class PersonServices {
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonServices.class.getName());

  public List<Person> findAll() {
    logger.info("Finding all people");

    List<Person> persons = new ArrayList<Person>();

    for (int i = 0; i < 8; i++) {
      Person person = mockPerson(i);
      persons.add(person);
    }

    return persons;
  }

  public Person findById(String id) {
    logger.info("Finding one person");

    Person person = new Person();

    person.setId(counter.incrementAndGet());
    person.setFirstName("Jack");
    person.setLastName("Brand");
    person.setAddress("Rua Pa PA");
    person.setGender("Male");

    return person;
  }

  public Person create(Person person) {
    logger.info("Creating one person");
    logger.info(person.getFirstName());

    return person;
  }

  public Person update(Person person) {
    logger.info("Update one person");

    return person;
  }

  public void delete(String id) {
    logger.info("Deleting one person");
  }

  private Person mockPerson(int i) {
    Person person = new Person();

    person.setId(counter.incrementAndGet());
    person.setFirstName("Jack --" + i);
    person.setLastName("Brand --" + i);
    person.setAddress("Rua Pa PA --" + i);
    person.setGender("Male -- " + i);

    return person;
  }
}
