package com.bruceliu.test;

import com.bruceliu.mapper.EmpMapper;
import com.bruceliu.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 10:58
 * @QQ:1241488705
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMyBatis {

    @Autowired
    EmpMapper empMapper;

    @Test
    public void testLogin(){
        Emp emp=new Emp();
        emp.setNo("qf000001");
        emp.setPass("admin");
        Emp emp1 = empMapper.login(emp);
        System.out.println(emp1);
    }

}
