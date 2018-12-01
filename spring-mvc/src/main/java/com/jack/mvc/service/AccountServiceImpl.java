package com.jack.mvc.service;

import com.jack.mvc.entity.Account;
import com.jack.mvc.exception.JackException;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * 用户服务接口实现.
 * @author yangyueming
 */
@Service
public class AccountServiceImpl implements AccountService {


    @Override
    public Account findAccessTokenIsValid(String accessToken, Date validityDate) throws JackException {
        return null;
    }

    @Override
    public boolean checkEmailIsActivated(Long userId, String email) {
        return false;
    }

    @Override
    public void updateEmailActivateStatus(Long userId, String email, String pwd) {

    }
}
