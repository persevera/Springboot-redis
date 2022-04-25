package com.Controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class doString {
    //自动注入操作Redis数据库的对象
    @Resource
    private StringRedisTemplate stringredisTemplate;

    @RequestMapping("/doString")
    public void doString(String key,String value){
        key="key1";
        value="value1";
        ValueOperations<String, String> stringStringValueOperations = stringredisTemplate.opsForValue();
        //1.添加数据
        stringStringValueOperations.set(key,value);
        /*
        2.添加数据并且设置生存时间
               参数3:生存时间
               参数4:时间单位
         */
        stringStringValueOperations.set(key,value,100, TimeUnit.MINUTES);
        //3.如果不存在加入数据,存在不加入
        stringStringValueOperations.setIfAbsent(key,value);
        //4.以Map集合的形式批量加入
        Map<String,String> mapvalue=new HashMap<>();
        mapvalue.put(key,value);
        stringStringValueOperations.multiSet(mapvalue);
        //5.如果不存在加入数据,存在不加入
        stringStringValueOperations.multiSetIfAbsent(mapvalue);
        //6.根据key获取value的值
        stringStringValueOperations.get(key);
        //7.截取一段字符
        stringStringValueOperations.get(key,1,5);
        //8.设置新值返回旧值
        stringStringValueOperations.getAndSet(key,value);
        //9.根据key批量获取value
        Set<String>  keyset=new HashSet<>();
        keyset.add("key1");
        keyset.add("key2");
        stringStringValueOperations.multiGet(keyset);
        //10.以增量的形式改变值,如果值不能进行运算会出异常
        stringStringValueOperations.increment(key,5);
        //11.在原有基础上行减运算
        stringStringValueOperations.decrement(key,5);
        //12.在原有字符的基础上追加新的字符
        stringStringValueOperations.append(key,"hello");
    }
}
