package com.itunion.guava.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(value = "首页", description = "首页")
@RequestMapping("/")
@RestController
public class IndexController {
    @ApiOperation(value = "Hello Spring Boot", notes = "Hello Spring Boot")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello Spring Boot";
    }
    @ApiOperation(value = "API 页面", notes = "接口列表")
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public void api(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }
}
