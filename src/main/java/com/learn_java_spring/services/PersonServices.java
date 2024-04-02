package com.learn_java_spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn_java_spring.exceptions.ResourceNotFoundException;
import com.learn_java_spring.models.Person;
import com.learn_java_spring.repositories.PersonRepository;

@Service
public class PersonServices {
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonServices.class.getName());

  @Autowired
  PersonRepository repository;

  public List<Person> findAll() {
    logger.info("Finding all people");

    // List<Person> persons = new ArrayList<Person>();

    // for (int i = 0; i < 8; i++) {
    // Person person = mockPerson(i);
    // persons.add(person);
    // }

    return repository.findAll();
  }

  public Person findById(Long id) {
    logger.info("Finding one person");

    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
  }

  public Person create(Person person) {
    logger.info("Creating one person");
    logger.info(person.getFirstName());

    return repository.save(person);
  }

  public Person update(Person person) {
    logger.info("Update one person");

    var entity = repository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());

    return repository.save(person);
  }

  public void delete(Long id) {
    logger.info("Deleting one person");

    var entity = repository.findById((id))
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    repository.delete(entity);
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
