package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;

import java.util.List;

public interface PersonMapper {

    Integer insertPerson(Person person);

    Person queryById(Integer id);

    List<Person> queryAll();

    Integer updatePerson(Person person);

    Integer deletePerson(Integer id);

}
