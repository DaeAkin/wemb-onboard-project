package com.wemb.toy.domain.user.utils;


import com.wemb.toy.domain.user.dao.UserRepository;
import com.wemb.toy.domain.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserFixture {

    public static User makeUser(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        User user = new User();
//        user.initialize(passwordEncoder);
//
//        Optional<User> donghyeon = userRepository.findByEmail("donghyeon");
//
//        if(!donghyeon.isPresent()){
//            userRepository.save(user);
//        }
        return user;
    }
}
