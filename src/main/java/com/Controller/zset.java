package com.Controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class zset {
    //自动注入操作Redis数据库的对象
    @Resource
    private StringRedisTemplate stringredisTemplate;

    @RequestMapping("dozset")
    public  void  dozset(){
        ZSetOperations<String, String> stringStringZSetOperations = stringredisTemplate.opsForZSet();
        /*方便查看删除这个和最后一个注释


//添加
        1.add(K,V,S)：
//键为K的集合，Smin<=score<=Smax的元素个数
        2.count(K,Smin,Smax)：
//键为K的集合元素个数
        3.size(K)：
//键为K的集合，value为obj的元素分数
        4.score(K,obj)：
//元素分数增加，delta是增量
        5.incrementScore(K,V,delta)：
//K集合与otherK[s]集合，共同的交集元素存到destK（复制），返回元素个数
        6.intersectAndStore(K,otherK[s],destK)：
//K集合与otherK[s]集合，共同的并集元素存到destK（复制），返回元素个数
        unionAndStore(K,otherK[s],destK)：
//键为K的集合，索引start<=index<=end的元素子集，正序
        7.range(K,start,end)：
//键为K的集合，索引start<=index<=end的元素子集，倒序
        reverseRange(K,start,end)：
//键为K的集合，offerset和count是限制条件，从索引1开始找到count个元素=子集，从子集中找到Smin<=score<=Smax的元素集合，返回Set，正序
        8.rangeByScore(K,Smin,Smax,[offset],[count])：
//键为K的集合，offerset和count是限制条件，从索引1开始找到count个元素=子集，从子集中找到Smin<=score<=Smax的元素集合，返回Set，倒序
        reverseRangeByScore(K,Smin,Smax,[offset],[count])：
//键为K的集合，offerset和count是限制条件，从索引1开始找到count个元素=子集，从子集中找到Smin<=score<=Smax的元素集合，返回泛型接口（包括sc正序
        9.rangeByScoreWithScores(K,Smin,Smax,[offset],[count])：ore和value），
//键为K的集合，offerset和count是限制条件，从索引1开始找到count个元素=子集，从子集中找到Smin<=score<=Smax的元素集合，返回泛型倒序
        reverseRangeByScoreWithScores(K,Smin,Smax,[offset],[count])：接口（包括score和value），
//键为K的集合，索引start<=index<=end的元素子集，返回泛型接口（包括score和value），正序
        10.rangeWithScores(K,start,end)：
//键为K的集合，索引start<=index<=end的元素子集，返回泛型接口（包括score和value），倒序
        reverseRangeWithScores(K,start,end)：
//键为K的集合，value为obj的元素索引，正序
        11.rank(K,obj)：
//键为K的集合，value为obj的元素索引，倒序
        reverseRank(K,obj)：
//删除，键为K的集合，value为obj的元素
        12.remove(K,obj)：
//删除，键为K的集合，索引start<=index<=end的元素子集
        13.removeRange(K,start,end)：
//删除，键为K的集合，Smin<=score<=Smax的元素，返回删除个数
        14.removeRangeByScore(K,Smin,Smax)：
*/
    }
}
