/**
 *
 */
package com.jack.mvc.service;

import com.jack.mvc.entity.Authority;
import com.jack.mvc.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Authority 服务接口的实现.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年5月30日
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Optional<Authority> getAuthorityById(Long id) {
        return authorityRepository.findById(id);
    }

}
