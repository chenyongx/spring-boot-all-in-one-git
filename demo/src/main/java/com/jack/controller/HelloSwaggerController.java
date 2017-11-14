package com.jack.controller;

import com.jack.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
@Api(description = "hello", basePath = "hello")
public class HelloSwaggerController {

    @RequestMapping("/")
    @ResponseBody
    @ApiOperation(value = "查询设备信息")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = User.class),
        @ApiResponse(code = 1001, message = "token is null"),
        @ApiResponse(code = 1002, message = "token is invaild"),
        @ApiResponse(code = 1004, message = "parameter null")})
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloSwaggerController.class, args);
    }
}