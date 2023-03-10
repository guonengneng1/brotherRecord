package org.example.brotherRecord.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class RedisDemoApplicationTest2 {
    @Autowired
    private RedisTemplate redisTemplate;
    // 注入 RedisTemplate
    @Test
    void testStringOper02(){
        //设置key的序列化
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.string());
        //设置hash的序列化方式
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "pl");
        valueOperations.get("name");

    }

    @Test
    void testHashOper01(){
        //1.获取hash操作对象
        HashOperations hashOperations = redisTemplate.opsForHash();
        //2.以hash类型存储数据
        hashOperations.put("blog", "id", "100");
        hashOperations.put("blog", "title", "redis。。。");
        Object id = hashOperations.get("blog", "id");
        Object title = hashOperations.get("blog", "title");
        System.out.println(id);
        System.out.println(title);
        Map blog = hashOperations.entries("blog");
        System.out.println(blog);
        //

    }

}
