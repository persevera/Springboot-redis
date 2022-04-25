package com.Controller;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class hash {
    //自动注入操作Redis数据库的对象
    @Resource
    private StringRedisTemplate stringredisTemplate;
    @RequestMapping("dohash")
    public  void   dohash(){
        HashOperations<String, Object, Object> hash = stringredisTemplate.opsForHash();
        hash.put("hash1", "aaa", "111"); //put
        hash.put("hash1", "bbb", "222");
        hash.put("hash1", "ccc", "333");

        System.out.println(hash.size("hash1")); //长度

        hash.entries("hash1").forEach((k,v) -> { //显示所有的key和value
            System.out.println(k + "=" + v);
        });

        hash.keys("hash1").stream().forEach(System.out::println); //显示所有的key
        hash.values("hash1").stream().forEach(System.out::println); //显示所有的value

        System.out.println(hash.putIfAbsent("hash1", "aaa", "aaa")); //没有key才put

        hash.increment("hash1", "count", 1); //数值自增
        System.out.println(hash.get("hash1", "count"));

        hash.increment("hash1", "count", 1);
        System.out.println(hash.get("hash1", "count"));

        hash.increment("hash1", "count", -1);
        System.out.println(hash.get("hash1", "count"));

        System.out.println(hash.hasKey("hash1", "amount")); //判断key是否存在
        System.out.println(hash.get("hash1", "count"));
        hash.delete("hash1", "count"); //删除

    }
}
