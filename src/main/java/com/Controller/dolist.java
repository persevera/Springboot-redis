package com.Controller;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Controller
public class dolist {
    //自动注入操作Redis数据库的对象
    @Resource
    private StringRedisTemplate stringredisTemplate;

    @RequestMapping("dolist")
    @ResponseBody
    public  void  dolist(String key,String value){
        ListOperations<String, String> stringStringListOperations = stringredisTemplate.opsForList();
        /*获取集合中指定范围的元素
        K key：集合key
        long start：起始位置
        long end：结束位置
         */
        stringStringListOperations.range(key,1,3);
         /*
       修剪集合中指定范围的元素
        这里的修剪的意思就是把start到end之间的集合数据保留，其余的全部删除
        K key：集合key
        long start：起始位置
        long end：结束位置
          */
        stringStringListOperations.trim(key,2,5);
        /*
        获取集合的长度
         K key：集合key
         */
        stringStringListOperations.size(key);
        /*
             向集合中添加一个元素,从左到右
         K key：集合key
        V value：key对应的值
         */
        stringStringListOperations.leftPush(key,"你好");
        /*
        向集合中添加一个或多个元素，从左到右
         K key：集合key
        V... values：key对应的值
         */
        stringStringListOperations.leftPushAll(key,"早上","中午","晚上");
        /*
        向集合中添加一个或多个元素，元素以集合的方式存在，从左到右
        K key：集合key
        Collection<V> values：key对应的值集合
         */
        Set<String> mapset=new HashSet<>();
        mapset.add("hu");
        mapset.add("fh");
       stringStringListOperations.leftPush(key, String.valueOf(mapset));
       /*
          仅当集合存在时，向集合中添加一个元素，从左到右
          K key：集合key V
        value：key对应的值
        */
        stringStringListOperations.leftPushIfPresent(key,value);
        /*
        向集合中添加一个元素，该元素添加在某一个已经存在的元素前边
         K key：集合key
        V pivot：集合中已存在的元素
        V value：一个新元素
         */
        stringStringListOperations.leftPush(key,"已经存在的","新元素");
        /*
         pivot代表已经存在的元素，value代表新元素

        如：[1,2,3] 这是当前集合中的所有元素，现在向这个集合中添加一个元素6

        并且将6添加到2的前边，这时方法的参数 pivot则为2，value为6

        注：搜索顺序是从左往右
         */
 stringStringListOperations.rightPush(key,"hello");
/*
        向集合中添加一个或多个新元素，从右往左
        K key：集合key
        V... values：key对应的值
 */
        stringStringListOperations.rightPushAll(key,"元素1","元素2","元素3");
/*
  K key：集合key
        V... values：key对应的值
        向集合中添加一个或多个新元素，从右往左
 */

        stringStringListOperations.rightPushAll(key,mapset);
/*
         向集合中添加一个或多个元素，元素以集合的方式存在，从右到左
          K key：集合key
         Collection<V> values：key对应的值集合

 */
        stringStringListOperations.rightPushIfPresent(key,"hu");
        /*
           K key：集合key V
        value：key对应的值
        仅当集合存在时，向集合中添加一个元素，从右到左
         */

        stringStringListOperations.rightPush(key,"hu","hb");
/*
 向集合中添加一个元素，该元素添加在某一个已经存在的元素前边
        K key：集合key
        V pivot：集合中已存在的元素
        V value：一个新元素
 */

        stringStringListOperations.set(key,1,"hu");
/*
    K key：集合key
        long index：索引
        V value：key对应的值
        向集合中指定索引下添加一个新元素，并覆盖当前集合中指定位置的值
 */

       stringStringListOperations.remove(key,6, "okll");

/*

        K key：集合key
        long index：索引
                根据索引获取集合中的元素
 */
       stringStringListOperations.index(key,8);

        //删除集合中所有的元素，并返回集合总第一个元素，从左往右
        stringStringListOperations.leftPop(key);
        /*
          K key：集合key
        删除集合中所有的元素，并返回集合总第一个元素，从左往右
         */

        stringStringListOperations.leftPop(key,20,TimeUnit.MINUTES);
        /*
          K key：集合key
        long timeout：连接超时时长
        TimeUnit unit：超时时间单位
        删除集合中所有的元素，并返回集合总第一个元素；从左往右
         */

       stringStringListOperations.rightPop(key);
       /*
        删除集合中所有的元素，并返回集合总最后一个元素，从右往左
        */

        stringStringListOperations.rightPop(key,20,TimeUnit.MINUTES);
        /*
         在原集合中删除最后一个元素，添加到目标几何中的头部（添加顺序是从左往右）
         */
        stringStringListOperations.rightPopAndLeftPush("key1","key2");
        /*
      在原集合中删除最后一个元素，添加到目标几何中的头部（添加顺序是从左往右）
         */
        stringStringListOperations.rightPopAndLeftPush("key1","key2",20, TimeUnit.MINUTES);

    }
}
