package com.itunion.guava.service;

import java.util.Map;

/**
 * @Auther: lin
 * @Date: 2019-03-14 14:46
 * @Description: 测试缓存服务
 */
public interface CacheGuavaService {

    Map<String,String> getUserCache();

    String executeSeckill();

}
