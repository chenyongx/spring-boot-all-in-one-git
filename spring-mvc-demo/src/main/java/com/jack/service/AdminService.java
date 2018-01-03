package com.jack.service;

import com.jack.demo.entity.Admin;
import com.jack.exception.JackException;

/**
 * @author yangyueming
 */
public interface AdminService {
    Admin find(String accessToken) throws JackException;
    Admin login(String account, String pwd) throws JackException;
}
