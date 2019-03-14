package com.itunion.guava.service.impl;

import com.itunion.guava.service.CacheGuavaService;
import com.itunion.guava.service.GuavaRateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lin
 * @Date: 2019-03-14 14:46
 * @Description: 测试缓存服务
 */
@Service
public class CacheGuavaServiceImpl implements CacheGuavaService {

    @Autowired
    private GuavaRateLimiterService guavaRateLimiterService;

    @Cacheable(value = "guavacache")
    @Override
    public Map<String, String> getUserCache() {
        new Thread().start();
        while(true){
            try {
                Map<String,String> userMap = new HashMap<>();
                userMap.put("name","IT实战联盟");
                userMap.put("url","https://100boot.cn");
                userMap.put("address","上海");
                Thread.sleep(5000);
                return userMap;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    @Transactional
    public String executeSeckill() {
        // 验证是否被限流器限制，如果没有，则继续往下执行业务
        if(guavaRateLimiterService.tryAcquireSeckill()){
            return "哈哈哈，你没有限制住我！啦啦啦啦！";
        }else {
            //被限流器限制
            return "呜呜呜，竟然限制我！！！";
        }
    }
}
