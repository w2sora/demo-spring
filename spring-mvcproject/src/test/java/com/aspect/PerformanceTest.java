package com.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:context/applicationContext-base.xml", "classpath:context/applicationContext-dataSource.xml"})
public class PerformanceTest {

    private static final String STR = "Nico Nico Ni~";

    @Autowired
    private Performance performance;

    @Test
    public void testPerformance() {
        performance.perform(STR);
    }

}
