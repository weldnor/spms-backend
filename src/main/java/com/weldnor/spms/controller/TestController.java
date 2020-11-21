package com.weldnor.spms.controller;

import com.weldnor.spms.security.JwtUserDetailsService;
import com.weldnor.spms.security.jwt.JwtTokenProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtUserDetailsService jwtUserDetailsService;

    public TestController(JwtTokenProvider jwtTokenProvider, JwtUserDetailsService jwtUserDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @GetMapping("/test")
    public String test(HttpServletRequest httpServletRequest) {
        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        String username = jwtTokenProvider.getUsername(token);
        return String.valueOf(jwtUserDetailsService.loadUserByUsername(username));
    }
}
