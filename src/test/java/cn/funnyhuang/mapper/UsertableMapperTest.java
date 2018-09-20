package cn.funnyhuang.mapper;

import cn.funnyhuang.model.Usertable;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UsertableMapperTest {
    ApplicationContext applicationContext;
    UsertableMapper usertableMapper;
    @Before
    public void setUp() throws Exception {

        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        usertableMapper = (UsertableMapper) applicationContext.getBean("usertableMapper");
    }

    @Test
    public void deleteByPrimaryKey() {
        usertableMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insert() {
        Usertable usertable = new Usertable();
        usertable.setPhonenumber("13112345671");
        usertable.setNickname("小星星");
        usertable.setSex(1);
        usertable.setPassword("123456");
        usertableMapper.insert(usertable);
    }

    @Test
    public void selectByPrimaryKey() {
        Usertable usertable = usertableMapper.selectByPrimaryKey(1);
        System.out.println(usertable);
    }

    @Test
    public void updateByPrimaryKey() {
        Usertable usertable = new Usertable();
        usertable.setUserid(2);
        usertable.setNickname("张三");
        usertableMapper.updateByPrimaryKey(usertable);
    }
}