package com.jack.mvc.service;

import com.jack.mvc.entity.Account;
import com.jack.mvc.exception.JackException;

import java.util.Date;

/**
 * 帐号信息接口
 *
 * @author yangyueming
 */
public interface AccountService {

    /**
     * 验证accessToken是否有效
     *
     * @param accessToken accessToken
     * @return 用户ID, token过期时间信息
     */
    Account findAccessTokenIsValid(String accessToken, Date validityDate) throws JackException;


    /**
     * 检查用户邮箱地址是否已经激活
     *
     * @param userId 用户ID
     * @param email 邮箱地址
     * @return 邮箱激活状态
     */
    boolean checkEmailIsActivated(Long userId, String email);

    /**
     * 邮箱激活修改邮箱地址和激活状态
     *
     * @param userId 用户ID
     * @param email 邮箱地址
     * @param pwd 密码
     */
    void updateEmailActivateStatus(Long userId, String email, String pwd);
}
