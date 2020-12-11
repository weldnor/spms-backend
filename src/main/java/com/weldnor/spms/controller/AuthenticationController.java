package com.weldnor.spms.controller;

import com.weldnor.spms.dto.AuthenticationRequestDto;
import com.weldnor.spms.dto.NewUserDto;
import com.weldnor.spms.entity.GlobalRole;
import com.weldnor.spms.entity.User;
import com.weldnor.spms.mapper.UserMapper;
import com.weldnor.spms.repository.GlobalRoleRepository;
import com.weldnor.spms.repository.UserRepository;
import com.weldnor.spms.security.jwt.JwtTokenProvider;
import com.weldnor.spms.security.oauth.VkAuthService;
import com.weldnor.spms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final VkAuthService vkAuthService;

    private final UserRepository userRepository;

    private final GlobalRoleRepository globalRoleRepository;

    private final UserMapper userMapper;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, VkAuthService vkAuthService, UserRepository userRepository, GlobalRoleRepository globalRoleRepository, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.vkAuthService = vkAuthService;
        this.userRepository = userRepository;
        this.globalRoleRepository = globalRoleRepository;
        this.userMapper = userMapper;
    }

    @PostMapping("/api/public/login/basic")
    public Map<Object, Object> login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));

            User user = userService.getByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));

            String token = jwtTokenProvider.createToken(user);

            Map<Object, Object> response = new HashMap<>();
            response.put("user_id", user.getUserId());
            response.put("token", token);

            return response;
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/api/public/register")
    public Map<Object, Object> register(@RequestBody @Valid NewUserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        GlobalRole userRole = globalRoleRepository.findByName("USER").orElseThrow();
        user.getGlobalRoles().add(userRole);
        user = userRepository.save(user);

        String token = jwtTokenProvider.createToken(user);
        Map<Object, Object> response = new HashMap<>();
        response.put("user_id", user.getUserId());
        response.put("token", token);
        return response;
    }

    @GetMapping("/api/public/login/oauth")
    public Object loginWithOauth2(@RequestParam("code") String code) throws Exception {
        String email = vkAuthService.getEmail(code);

        User user = userService.getByEmail(email)
                .orElseThrow(() -> new Exception("cant find user by email"));

        String token = jwtTokenProvider.createToken(user);
        Map<Object, Object> response = new HashMap<>();
        response.put("user_id", user.getUserId());
        response.put("token", token);
        return response;
    }
}