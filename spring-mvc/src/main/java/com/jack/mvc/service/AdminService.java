package com.jack.mvc.service;

import com.jack.mvc.entity.Admin;
import com.jack.mvc.exception.JackException;

/**
 * @author yangyueming
 */
public interface AdminService {
    Admin find(String accessToken) throws JackException;

    Admin login(String account, String pwd) throws JackException;
}
