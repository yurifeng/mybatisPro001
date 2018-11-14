package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;
import com.yuri.maven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/***
 * 会为接口自动创建一个代理对象,代理对象去执行CRUD操作
 */
public class PersonMapperTest {

    /**
     * 使用单例模式获取sqlSession
     */
    SqlSession sqlSession = MyBatisUtil.sqlSession();


    /**
     * 测试queryById
     */
    @Test
    public void queryById() {
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.queryById(3);
        System.out.println(person);

        //得到的是代理类型
        System.out.println(personMapper.getClass());
    }

    /**
     * 测试queryAll
     */
    @Test
    public void queryAll() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personList = mapper.queryAll();
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    /**
     * 测试插入insertPerson
     */
    @Test
    public void insertPerson() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person p = new Person(7, "Micheal", 30, "743546464");
        Integer integer = mapper.insertPerson(p);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("已添加{" + integer + "}条记录");
    }

    /**
     * 测试更新数据
     */
    @Test
    public void updatePerson() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person p = new Person(6, "htt", 00, "0101010101");
        Integer integer = mapper.updatePerson(p);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("成功更新记录:" + "{" + integer + "}" + "条");
    }

    /**
     * 测试删除数据
     */
    @Test
    public void deletePerson() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Integer integer = mapper.deletePerson(4);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("成功删除记录:" + "{" + integer + "}" + "条");
    }
}