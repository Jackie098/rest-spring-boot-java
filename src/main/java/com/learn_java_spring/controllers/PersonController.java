package com.learn_java_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_java_spring.models.Person;
import com.learn_java_spring.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  private PersonServices service;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person findById(@PathVariable(value = "id") String id) throws Exception {

    return service.findById(id);
  }
}
