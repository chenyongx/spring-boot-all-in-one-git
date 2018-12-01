package com.jack.mvc.service;

import com.jack.mvc.entity.Admin;
import com.jack.mvc.exception.JackException;
import org.springframework.stereotype.Service;


/**
 * 用户服务接口实现.
 * @author yangyueming
 */
@Service
public class AdminServiceImpl implements AdminService {


    @Override
    public Admin find(String accessToken) throws JackException {
        return null;
    }

    @Override
    public Admin login(String account, String pwd) throws JackException {
        return null;
    }
}
