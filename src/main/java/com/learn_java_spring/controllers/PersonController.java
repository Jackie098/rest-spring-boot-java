package com.learn_java_spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_java_spring.data.vo.v1.PersonVO;
import com.learn_java_spring.data.vo.v2.PersonVOV2;
import com.learn_java_spring.services.PersonServices;
import com.learn_java_spring.utils.MediaType;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
  @Autowired
  private PersonServices service;

  @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML })
  public List<PersonVO> findAll() {

    return service.findAll();
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YAML })
  public PersonVO findById(@PathVariable(value = "id") Long id) {

    return service.findById(id);
  }

  @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YAML }, produces = {
          MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML })
  public PersonVO create(@RequestBody PersonVO person) {

    return service.create(person);
  }

  @PostMapping(value = "/v2", consumes = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML }, produces = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML })
  public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {

    return service.createV2(person);
  }

  @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YAML }, produces = {
          MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML })
  public PersonVO update(@RequestBody PersonVO person) {

    return service.update(person);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
