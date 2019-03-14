package com.itunion.guava.service;


/**
 * @Auther: lin
 * @Date: 2019-03-14 14:46
 * @Description: Guava限流
 */
public interface GuavaRateLimiterService {
    
    /**
     *
     * 功能描述: 
     *
     * @param: 尝试获取令牌
     * @return: 
     * @auther: lin
     * @date: 2019-03-14 16:44
     */
    boolean tryAcquireSeckill();

}
