package com.jack.demo.web;

import com.jack.annotation.DisableAuth;
import com.jack.demo.entity.Admin;
import com.jack.exception.MessageKey;
import com.jack.exception.JackException;
import com.jack.service.AdminService;
import com.jack.vo.ResponseVO;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员用户管理控制层
 *
 * @author yangyueming
 */
@RestController
@RequestMapping(value = "/", method = RequestMethod.POST)
@Log4j2
public class AdminController {

    @Autowired
    private AdminService adminService;

    @DisableAuth
    @RequestMapping(value = "admin/login")
    public ResponseVO save(@RequestBody Admin admin) throws Exception {
        // 1. 判断参数是否为空
        if (admin == null || StringUtils.isBlank(admin.getAccount())
            || StringUtils.isBlank(admin.getPwd())) {
            throw new JackException(MessageKey.PARAMETER_ERROR);
        }
        Admin resultAdmin = adminService.login(admin.getAccount(), admin.getPwd());
        // 4. 设置返回值
        ResponseVO responseVO = new ResponseVO(MessageKey.RETURN_OK);
        resultAdmin.setPwd(null);
        responseVO.setData(resultAdmin);
        return responseVO;
    }

}
