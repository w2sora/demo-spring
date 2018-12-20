package web.com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;

public class RedisDemo {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    public String redisString() {
        RedisConnection conn = redisConnectionFactory.getConnection();
        byte[] bytes = conn.get("foo".getBytes());
        return new String(bytes != null ? bytes : new byte[0]);
    }
}
