package com.wemb.toy.domain.user.application;


import com.wemb.toy.domain.user.dao.UserRepository;
import com.wemb.toy.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    public void makeDonghyeon() {
        User donghyeon = new User("user1", "1234", 25);
        donghyeon.initialize(passwordEncoder);
        userRepository.save(donghyeon);

        User user2 = new User("user2", "1234", 25);
        user2.initialize(passwordEncoder);
        userRepository.save(user2);

        User user3 = new User("user3", "1234", 25);
        user3.initialize(passwordEncoder);
        userRepository.save(user3);

    }

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username);
    }
}
