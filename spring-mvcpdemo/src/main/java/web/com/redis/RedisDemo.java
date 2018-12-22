package web.com.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

class RedisDemo {

    private static final Logger log = LoggerFactory.getLogger(RedisDemo.class);

    String redisString(StringRedisTemplate redis) {
        String s = redis.opsForValue().get("foo");
        log.info("########## foo: {} ##########", s);

        return s;
    }
}
