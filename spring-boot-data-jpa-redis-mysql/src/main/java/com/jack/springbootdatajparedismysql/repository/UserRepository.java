package com.jack.springbootdatajparedismysql.repository;

import com.jack.springbootdatajparedismysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 19511
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

}
