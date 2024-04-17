package com.learn_java_spring.unittests.mockito.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.Optional;

import com.learn_java_spring.models.Person;
import com.learn_java_spring.repositories.PersonRepository;
import com.learn_java_spring.services.PersonServices;
import com.learn_java_spring.unittests.mappers.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {
  MockPerson input;

  @InjectMocks
  private PersonServices service;

  @Mock
  PersonRepository repository;

  @BeforeEach
  void setUpMokcs() throws Exception {
    input = new MockPerson();

    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindById() {
    Person person = input.mockEntity();
    person.setId(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(person));

    var result = service.findById(1L);
  }
}
