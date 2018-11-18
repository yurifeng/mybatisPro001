package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yurifeng
 * @create 2018-11-16 16:35
 * @PACKAGE_NAME com.yuri.maven.dao
 * @PROJECT_NAME mybatisPro001
 */
public interface PersonMapperDynamicSQL {

    /**
     * 使用DynamicSQL查询(If/Where)
     *
     * @return
     */
    List<Person> getPersonByConditionIf(Person person);

    /**
     * 使用DynamicSQL查询(Trim)
     *
     * @param person
     * @return
     */
    List<Person> getPersonByConditionTrim(Person person);

    /**
     * 使用DynamicSQL查询(Choose)
     *
     * @param person
     * @return
     */
    List<Person> getPersonByConditionChoose(Person person);


    void updatePerson(Person person);


    /**
     * 使用DynamicSQL查询(Foreach)
     *
     * @param ids
     * @return
     */
    List<Person> getPersonByConditionForeach(@Param("ids") List<Integer> ids);


}
