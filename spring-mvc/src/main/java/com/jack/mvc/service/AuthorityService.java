package com.jack.mvc.service;

import com.jack.mvc.entity.Authority;

import java.util.Optional;


/**
 * Authority 服务接口.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年5月30日
 */
public interface AuthorityService {
    /**
     * 根据ID查询 Authority
     *
     * @param id
     * @return
     */
    Optional<Authority> getAuthorityById(Long id);
}
