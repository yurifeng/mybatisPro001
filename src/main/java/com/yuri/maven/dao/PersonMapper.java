package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;

import java.util.List;

public interface PersonMapper {

    //void insertPerson(Person person);

    Person queryById(int id);

    List<Person> queryAll();

    //void updatePerson(int id);
}
