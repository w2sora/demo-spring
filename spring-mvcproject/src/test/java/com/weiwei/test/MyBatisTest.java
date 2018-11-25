package com.weiwei.test;

import com.weiwei.service.MyBatisTestService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:context/applicationContext-base.xml", "classpath:context/applicationContext-dataSource.xml"})
public class MyBatisTest {
    // private static Logger logger = null;
    private static final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    @Autowired
    private MyBatisTestService service;

    @BeforeClass
    public static void setLogger() {
        // 自定义Log4j2配置文件路径
        // 该方法在不使用Spring测试框架的情况下起作用，如果使用了Spring测试框架，则Log4j2的初始化会先于@BeforeClass方法
        // System.setProperty("log4j.configurationFile", "classpath:config/log4j2.yml");
        // logger = LoggerFactory.getLogger(MyBatisTest.class);
    }

    @Test
    public void testQueryPassword() {
        String username = "weiwei";
        String password = service.queryPassword(username);
        logger.warn("查询成功，密码为：{}", password);
    }
}
