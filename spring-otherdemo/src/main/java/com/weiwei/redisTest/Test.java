package com.weiwei.redisTest;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Jedis j = new Jedis("192.168.100.2");

        Map<String, String> map = j.hgetAll("article:92617");
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            // for (Map.Entry<String, String> entry : map.entrySet()) {
            Map.Entry<String, String> entry = entries.next();
            System.out.println("key = " + entry.getKey() + "; value = " + entry.getValue());
        }

        j.close();
    }

}
