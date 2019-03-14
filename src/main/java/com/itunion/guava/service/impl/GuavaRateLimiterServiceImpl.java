package com.itunion.guava.service.impl;

import com.google.common.util.concurrent.RateLimiter;
import com.itunion.guava.service.GuavaRateLimiterService;
import org.springframework.stereotype.Service;

/**
 * @Auther: lin
 * @Date: 2019-03-14 14:46
 * @Description: 测试RateLimiter限流服务
 */
@Service
public class GuavaRateLimiterServiceImpl implements GuavaRateLimiterService {

    /**
     * 每秒钟只发出2个令牌，拿到令牌的请求才可以进入下一个业务
     */
    private RateLimiter seckillRateLimiter = RateLimiter.create(2);

    @Override
    public boolean tryAcquireSeckill() {
        return seckillRateLimiter.tryAcquire();
    }
}
