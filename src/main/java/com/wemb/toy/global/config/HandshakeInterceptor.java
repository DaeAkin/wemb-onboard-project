package com.wemb.toy.global.config;

import com.wemb.toy.domain.user.dao.UserRepository;
import com.wemb.toy.domain.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
//        attributes.put("users", userRepository.findById(user.getId()));
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
}
