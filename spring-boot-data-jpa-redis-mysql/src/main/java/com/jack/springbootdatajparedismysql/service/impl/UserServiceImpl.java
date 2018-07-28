package com.jack.springbootdatajparedismysql.service.impl;

import com.jack.springbootdatajparedismysql.entity.User;
import com.jack.springbootdatajparedismysql.repository.UserRepository;
import com.jack.springbootdatajparedismysql.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 19511
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    private Map<Long, User> userMap = new HashMap<>();
//    private Map<Long, Info> infoMap = new HashMap<>();

//    public UserServiceImpl() {
//        User user1 = new User();
//        user1.setId(1L);
//        user1.setUsername("1111");
//        user1.setPassword("11223434");
//        User user2 = new User();
//        user2.setId(1L);
//        user2.setUsername("1111");
//        user2.setPassword("11223434");
//        User user3 = new User();
//        user3.setId(1L);
//        user3.setUsername("1111");
//        user3.setPassword("11223434");
//
//        userMap.put(1L, user1);
//        userMap.put(2L, user2);
//        userMap.put(3L, user3);
////        infoMap.put(1L, new Info("18559198715", "福州市"));
//    }

    @Override
    public List<User> findAll() {
//        return Arrays.asList(userMap.values().toArray());
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "user", key = "'user'.concat(#id.toString())")
    public User findUserById(Long id) {
        //log.info("findUserById query from db, id: {}", id);
        System.out.println("findUserById query from db, id: {}======" + id);
//        return userMap.get(id);
        return userRepository.findUserById(id);
    }


    @Override
    @CachePut(value = "user", key = "'user'.concat(#user.id.toString())")
    public void update(User user) {
        //log.info("update db, user: {}", user.toString());
        System.out.println("findUserById query from db, id: {}======");
        userMap.put(user.getId(), user);
    }

    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public void remove(Long id) {
        //log.info("remove from db, id: {}", id);
        System.out.println("findUserById query from db, id: {}======");
        userMap.remove(id);
    }

    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public User upuser(Long id) {
        User d = userMap.get(id);
        d.setUsername("000000000000000000000000000000000000000000000000");
        return d;
    }
}