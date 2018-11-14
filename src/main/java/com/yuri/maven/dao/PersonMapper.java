package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonMapper {

    Integer insertPerson(Person person);

    Person queryById(Integer id);

    List<Person> queryAll();

    Integer updatePerson(Person person);

    Integer deletePerson(Integer id);

    /**
     * 多条件参数查询使用注解
     *
     * @param id
     * @param userName
     * @return Person
     */
    Person getPersonByIdAndName(@Param("id") Integer id, @Param("userName") String userName);


    /**
     * 使用封装的map查询数据(如果经常查询且量大,则不建议使用)
     *
     * @param map
     * @return Person
     */
    Person getPersonByMap(Map<String, Object> map);


    List<Person> getPersonByUserNameLike(String userName);


    /**
     * 返回一条记录的map:key就是列名,值就是对应的value
     *
     * @param id
     * @return map集合
     */
    Map<String, Object> getPersonByIdReturnMap(Integer id);


    /**
     * 返回多条记录的map:返回的是Map<Integer,Person>,Integer就是主键,Value就是封装好的JavaBean
     * 使用注解标识将id作为封装为map的key
     *
     * @param userName
     * @return
     */
    @MapKey("id")
    Map<Integer, Person> getPersonByUserNameReturnMap(String userName);

}
