package com.itunion.guava.web.controller;
import com.google.common.util.concurrent.RateLimiter;
import com.itunion.guava.service.CacheGuavaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private CacheGuavaService cacheGuavaService;

    /**
     * 查询方法
     */
    @ApiOperation(value = "getByCache", notes = "查询缓存")
    @RequestMapping(value = "getByCache", method = RequestMethod.GET)
    @ResponseBody
    public String getByCache() {
        Long startTime = System.currentTimeMillis();
        Map<String,String>  map = cacheGuavaService.getUserCache();
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
        System.out.println(map.toString());
        return map.toString();
    }

    /**
     * 测试限流器
     */
    @ApiOperation(value = "getRateLimiter", notes = "测试限流器")
    @RequestMapping(value = "getRateLimiter", method = RequestMethod.GET)
    @ResponseBody
    public String getRateLimiter() {
        String str = cacheGuavaService.executeSeckill();
        System.out.println(str+","+new Date());
        return str;
    }
}