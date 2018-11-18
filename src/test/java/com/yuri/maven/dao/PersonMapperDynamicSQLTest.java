package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;
import com.yuri.maven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yurifeng
 * @create 2018-11-16 16:38
 * @PACKAGE_NAME com.yuri.maven.dao
 * @PROJECT_NAME mybatisPro001
 */
public class PersonMapperDynamicSQLTest {


    SqlSession sqlSession = MyBatisUtil.sqlSession();

    /**
     * 测试DynamicSQL查询(if/when)
     */
    @Test
    public void getPersonByConditionIf() {
        PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
        Person person = new Person(3, "%j%", 30, null);
        mapper.getPersonByConditionIf(person).forEach(System.out::println);
    }

    /**
     * 测试DynamicSQL查询(trim)
     */
    @Test
    public void getPersonByConditionTrim() {
        PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
        Person person = new Person();
        person.setUserName("%j%");
        mapper.getPersonByConditionTrim(person).forEach(System.out::println);
    }

    /**
     * 测试DynamicSQL查询(Choose)
     */
    @Test
    public void getPersonByConditionChoose() {
        PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
        Person person = new Person(9, "j", null, null);
        mapper.getPersonByConditionChoose(person).forEach(System.out::println);
    }


    /**
     * 测试DynamicSQL查询(set/if)
     */
    @Test
    public void updatePerson() {
        PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
        Person person = new Person(2, "hah", 777, "xxxxxxxx");
        mapper.updatePerson(person);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试DynamicSQL查询(foreach)
     */
    @Test
    public void getPersonByConditionForeach() {
        PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
        mapper.getPersonByConditionForeach(Arrays.asList(1, 2, 3, 4, 5, 6)).forEach(System.out::println);
    }

    /**
     * 测试foreach批量存储数据
     */
    @Test
    public void addPersonsBatch() {
        PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
        List<Person> ps = new ArrayList<>();
        ps.add(new Person(null, "xxxx", 66, "!@#$%^&*()_+"));
        ps.add(new Person(null, "zzzz", 444, "ASDFGHJKL"));
        mapper.addPersonsBatch(ps);
        sqlSession.commit();
        sqlSession.close();
    }
}

