package web.com.redis;

import config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class RedisDemoTest {

    @Autowired
    private RedisConnectionFactory factory;

    @Test
    public void redisStringTest() {
        RedisDemo demo = new RedisDemo();
        String s = demo.redisString(factory);
        assertEquals("bar", s);
    }

}
