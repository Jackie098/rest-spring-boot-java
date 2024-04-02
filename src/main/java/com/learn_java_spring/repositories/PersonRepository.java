package com.learn_java_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn_java_spring.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
