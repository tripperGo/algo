package com.mright.test.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/6/2 17:07
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Qualifier("getRedissonClient")
    @Autowired
    private RedissonClient client;

    @GetMapping("/stock")
    public String stock() {
        RLock lock = client.getLock("product01");
        lock.lock();

        int stock = Integer.parseInt(redisTemplate.opsForValue().get("order_stock"));
        if (stock > 0) {
            stock--;
            redisTemplate.opsForValue().set("order_stock", stock + "");
            System.out.println("剩余库存：" + stock);
        } else {
            System.out.println("库存不足");
        }

        lock.unlock();
        return "SUCCESS";
    }
}
