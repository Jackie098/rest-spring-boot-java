package com.learn_java_spring.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.learn_java_spring.models.Person;

@Service
public class PersonServices {
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonServices.class.getName());

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
}
