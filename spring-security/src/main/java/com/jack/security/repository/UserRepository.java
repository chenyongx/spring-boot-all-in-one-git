package com.jack.security.repository;

import com.jack.security.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User Repository 接口.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年7月16日
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
