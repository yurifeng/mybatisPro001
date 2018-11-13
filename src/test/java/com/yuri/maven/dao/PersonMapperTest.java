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

/***
 * 会为接口自动创建一个代理对象,代理对象去执行CRUD操作
 */
public class PersonMapperTest {


    /**
     * 返回SqlSession
     *
     * @return
     * @throws IOException
     */
    public SqlSession getSqlSessionFactory() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


    /**
     * 测试queryById
     *
     * @throws IOException
     */
    @Test
    public void queryById() throws IOException {
        PersonMapper personMapper = getSqlSessionFactory().getMapper(PersonMapper.class);
        Person person = personMapper.queryById(3);
        System.out.println(person);

        //得到的是代理类型
        System.out.println(personMapper.getClass());
    }

    /**
     * 测试queryAll
     *
     * @throws IOException
     */
    @Test
    public void queryAll() throws IOException {
        PersonMapper mapper = getSqlSessionFactory().getMapper(PersonMapper.class);
        List<Person> personList = mapper.queryAll();

        for (Person person : personList) {
            System.out.println(person);
        }
    }

    /**
     * 测试插入insertPerson
     * @throws IOException
     */
    @Test
    public void insertPerson() throws IOException {
        PersonMapper mapper = getSqlSessionFactory().getMapper(PersonMapper.class);
        Person p = new Person();
        p.setUserName("AOC");
        p.setAge(20);
        p.setMobilePhone("768543543543");
        Integer integer = mapper.insertPerson(p);
        getSqlSessionFactory().commit();
        System.out.println("已添加{" + integer + "}条记录");


    }
}