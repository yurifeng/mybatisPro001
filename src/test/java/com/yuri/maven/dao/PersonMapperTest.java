package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PersonMapperTest {

    String resources="mybatis-config.xml";

    @Test
    public void queryById() throws IOException {


        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        PersonMapper personMapper = session.getMapper(PersonMapper.class);
        Person person = personMapper.queryById(3);
        System.out.println(person);
    }

    @Test
    public void queryAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personList = mapper.queryAll();

        for (Person person : personList) {
            System.out.println(person);
        }
        
    }
}