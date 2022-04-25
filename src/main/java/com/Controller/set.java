package com.Controller;

import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class set {
    //自动注入操作Redis数据库的对象
    @Resource
    private StringRedisTemplate stringredisTemplate;


    @RequestMapping("doset")
    public  void   doset(String key,String value){
        SetOperations<String, String> stringStringSetOperations =stringredisTemplate.opsForSet();
                /**
                 * 给集合key添加多个值，集合不存在创建后再添加
                 *
                 * @param key 不能为null
                 * @param values
                 * @return
                 */
                stringStringSetOperations.add(key,value);

        /**
         * 移除集合中多个value值
         * @param key 不能为null
         * @param values
         * @return
         */
        stringStringSetOperations.remove(key,value);

        /**
         * 随机删除集合中的一个值，并返回。
         *
         * @param key 不能为null
         * @return
         */
        stringStringSetOperations.pop(key);

        /**
         * 把源集合中的一个元素移动到目标集合。成功返回true.
         *
         * @param key 不能为null
         * @param value
         * @param destKey must not be {@literal null}.
         * @return
         */
        stringStringSetOperations.move(key, value,"K destKey");

        /**
         * 返回结合的大小
         *
         * @param key 不能为null
         * @return
         * @see <a href="http://redis.io/commands/scard">Redis Documentation: SCARD</a>
         */
        stringStringSetOperations.size(key);

        /**
         * 检查集合中是否包含某个元素
         *
         * @param key 不能为null
         * @param o
         * @return
         */
       stringStringSetOperations.isMember(key,"sjfopa");

        /**
         * 求指定集合与另一个集合的交集
         *
         * @param key 不能为null
         * @param otherKey must not be {@literal null}.
         * @return
         */
        stringStringSetOperations.intersect(key, "K otherKey");

        /**
         *求指定集合与另外多个个集合交集
         *
         * @param key 不能为null
         * @param otherKeys 不能为null
         * @return
         * @see <a href="http://redis.io/commands/sinter">Redis Documentation: SINTER</a>
         */
        stringredisTemplate.intersect(key,"map");

        /**
         * 求指定集合与另一个集合的交集，并且存储到目标集合中
         *
         * @param key 不能为null
         * @param otherKey 不能为null
         * @param destKey 不能为null
         * @return 返回目标集合的长度
         */
         stringStringSetOperations.intersectAndStore(key, "K otherKey", "K destKey");

        /**
         * 求指定集合与另外多个集合中的交集保存到目标集合
         *
         * @param key 不能为null
         * @param otherKeys 不能为null
         * @param destKey 不能为null
         * @return
         */
        stringStringSetOperations.intersectAndStore(key,"map", "K destKey");

        /**
         * 求指定集合与另一个集合的并集 并返回并集
         *
         * @param key 不能为null
         * @param otherKey 不能为null
         * @return
         * @see <a href="http://redis.io/commands/sunion">Redis Documentation: SUNION</a>
         */
        stringredisTemplate.union(key, "K otherKey");

        /**
         * 求指定集合与另外多个集合的并集 并返回并集
         *
         * @param key 不能为null
         * @param otherKeys 不能为null
         * @return
         * @see <a href="http://redis.io/commands/sunion">Redis Documentation: SUNION</a>
         */
        stringredisTemplate.union(key, Collection<K> otherKeys);

        /**
         *求指定集合与另一个集合的并集，并保存到目标集合
         */
       stringredisTemplate.unionAndStore(K key, K otherKey, K destKey);

        /**
         *求指定集合与另外多个集合的并集，并保存到目标集合
         */
        stringredisTemplate.unionAndStore(K key, Collection<K> otherKeys, K destKey);

        /**
         * 求指定集合与另一个集合的差集
         */
        stringredisTemplate.difference(K key, K otherKey);

        /**
         * 求指定集合与另外多个集合的差集
         */
        stringredisTemplate.difference(K key, Collection<K> otherKeys);

        /**
         * 求指定集合与另一个集合的差集，并保存到目标集合
         */
        stringredisTemplate.differenceAndStore(K key, K otherKey, K destKey);

        /**
         * 求指定集合与另外多个集合的差集，并保存到目标集合
         */
       stringredisTemplate.differenceAndStore(K key, Collection<K> otherKeys, K destKey);

        /**
         * 获取集合中的所有元素
         */
        stringredisTemplate.members(K key);

        /**
         * 随机获取集合中的一个元素
         */
       stringStringSetOperations.randomMember(K key);

        /**
         *随机返回集合中指定数量的元素。随机的元素不会重复
         */
       stringStringSetOperations.distinctRandomMembers(K key, long count);

        /**
         * 随机返回集合中指定数量的元素。随机的元素可能重复
         */
        stringStringSetOperations.randomMembers(K key, long count);

        /**
         * 获取集合的游标。通过游标可以遍历整个集合。
         * ScanOptions 这个类中使用了构造者 工厂方法 单例。 通过它可以配置返回的元素
         * 个数 count  与正则匹配元素 match. 不过count设置后不代表一定返回的就是count个。这个只是参考
         * 意义
         *
         * @param key
         * @param options
         * @return
         * @since 1.4
         */
      stringStringSetOperations.scan(K key, ScanOptions options);stringredisTemplate.opsForSet();

    }
}
