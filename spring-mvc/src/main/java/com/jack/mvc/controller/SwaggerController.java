package com.jack.mvc.controller;

import com.jack.mvc.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
@Api(description = "hello", basePath = "hello")
public class SwaggerController {
    @RequestMapping("/")
    @ApiOperation(value = "查询设备信息")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = User.class),
            @ApiResponse(code = 1001, message = "token is null"),
            @ApiResponse(code = 1002, message = "token is invaild"),
            @ApiResponse(code = 1004, message = "parameter null")})
    String home() {
        return "Hello World!";
    }
}
