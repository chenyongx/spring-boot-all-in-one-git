package com.jack.swagger.controller;

import com.jack.common.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "user", basePath = "user")
public class SwaggerController {
    @GetMapping("/")
    @ApiOperation(value = "查询设备信息")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = User.class)})
    String home() {
        return "Hello World!";
    }

    @PostMapping("/getUsername")
    @ApiOperation(value = "获取用户名称")
    @ApiImplicitParam(name = "username", value = "用户名称",required = true, dataType = "String")
    String getUsername(String username) {
        return "Hello World!" + username;
    }
}
