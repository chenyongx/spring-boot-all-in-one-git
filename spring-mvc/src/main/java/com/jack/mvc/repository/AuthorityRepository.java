package com.jack.mvc.repository;

import com.jack.mvc.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Authority 仓库.
 * 
 * @since 1.0.0 2017年5月30日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
}
