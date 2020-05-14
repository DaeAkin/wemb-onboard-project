package com.wemb.toy.domain.user.application;


import com.wemb.toy.domain.user.dao.UserRepository;
import com.wemb.toy.domain.user.utils.UserFixture;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final PasswordEncoder userPasswordEncoder;

    @PostConstruct
    public void init() {
        UserFixture.makeUser(userPasswordEncoder,userRepository);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username"  + username);
        return userRepository.findById(1L).get();
    }
}
