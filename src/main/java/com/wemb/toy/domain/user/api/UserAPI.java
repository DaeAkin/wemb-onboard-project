package com.wemb.toy.domain.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserAPI {

//    @Autowired AuthenticationManager authenticationManager;
//    @Autowired UserService userService;
//
//    @RequestMapping(value="/login", method=RequestMethod.POST)
//    public AuthenticationToken login(
//            @RequestBody AuthenticationRequest authenticationRequest,
//            HttpSession session
//    ) {
//        String username = authenticationRequest.getUsername();
//        String password = authenticationRequest.getPassword();
//
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication authentication = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
//                SecurityContextHolder.getContext());
//
//        User user = userService.readUser(username);
//        return new AuthenticationToken(user.getName(), user.getAuthorities(), session.getId());
//    }
}
