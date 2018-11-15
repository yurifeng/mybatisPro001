package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;
import com.yuri.maven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Person p = new Person("JohnCorner", 26, "0xffffff");
        Integer integer = mapper.insertPerson(p);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("已添加{" + integer + "}条记录");
        System.out.println(p.getId());
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

    /**
     * 测试多条件查询记录
     */
    @Test
    public void getPersonByIdAndName() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getPersonByIdAndName(6, "htt");
        System.out.println(person);
    }

    /**
     * 用封装的map查询数据
     */
    @Test
    public void getPersonByMap() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 6);
        map.put("userName", "htt");
        map.put("tableName", "person");
        Person person = mapper.getPersonByMap(map);
        System.out.println(person);

    }

    /**
     * 测试模糊查询
     */
    @Test
    public void getPersonByUserName() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> list = mapper.getPersonByUserNameLike("%j%");
        list.forEach(System.out::println);
    }

    /**
     * 测试返回一条记录的map
     */
    @Test
    public void getPersonByIdReturnMap() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Map<String, Object> returnMap = mapper.getPersonByIdReturnMap(3);
        System.out.println(returnMap);
    }


    /**
     * 测试返回多条记录的map
     */
    @Test
    public void getPersonByUserNameReturnMap() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Map<Integer, Person> returnMap = mapper.getPersonByUserNameReturnMap("%j%");
        System.out.println(returnMap);

    }

    /**
     * 测试返回封装的resultMap
     */
    @Test
    public void getPersonByIdPlus() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getPersonByIdPlus(3);
        System.out.println(person);
    }

    /**
     * 测试多表关联的查询的resultMap
     */
    @Test
    public void getPersonAndDept() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getPersonAndDept(3);
        System.out.println(person);
        System.out.println(person.getDept());
//        System.out.println(person.getDept().getLocation());
    }

}