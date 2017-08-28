package com.overflow.spel.demo.sepldemo.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebChecker {
        public boolean isLocalHost(Authentication authentication, HttpServletRequest request) {
            System.out.println("Server name" + request.getServerName());
            return "localhost".equals(request.getServerName());
        }
}
