package com.learn_java_spring.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn_java_spring.data.vo.v1.PersonVO;
import com.learn_java_spring.data.vo.v2.PersonVOV2;
import com.learn_java_spring.exceptions.ResourceNotFoundException;
import com.learn_java_spring.mappers.DozerMapper;
import com.learn_java_spring.mappers.custom.PersonMapper;
import com.learn_java_spring.models.Person;
import com.learn_java_spring.repositories.PersonRepository;

@Service
public class PersonServices {
  private Logger logger = Logger.getLogger(PersonServices.class.getName());

  @Autowired
  PersonRepository repository;

  @Autowired
  PersonMapper personMapper;

  public List<PersonVO> findAll() {
    logger.info("Finding all people");

    return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
  }

  public PersonVO findById(Long id) {
    logger.info("Finding one person");

    var entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    return DozerMapper.parseObject(entity, PersonVO.class);
  }

  public PersonVO create(PersonVO person) {
    logger.info("Creating one person");
    logger.info(person.getFirstName());

    var entity = DozerMapper.parseObject(person, Person.class);

    var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

    return vo;
  }

  public PersonVOV2 createV2(PersonVOV2 person) {
    logger.info("Creating one person V2");
    logger.info(person.getFirstName());

    var entity = personMapper.convertVoToEntity(person);

    var vo = personMapper.convertEntityToVo(repository.save(entity));

    return vo;
  }

  public PersonVO update(PersonVO person) {
    logger.info("Update one person");

    var entity = repository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());

    var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

    return vo;
  }

  public void delete(Long id) {
    logger.info("Deleting one person");

    var entity = repository.findById((id))
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    repository.delete(entity);
  }
}
