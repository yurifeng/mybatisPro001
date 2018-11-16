package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;

import java.util.List;

/**
 * @author yurifeng
 * @create 2018-11-16 16:35
 * @PACKAGE_NAME com.yuri.maven.dao
 * @PROJECT_NAME mybatisPro001
 */
public interface PersonMapperDynamicSQL {

    /**
     * 使用DynamicSQL查询
     *
     * @return
     */
    List<Person> getPersonByConditionIf(Person person);
}
