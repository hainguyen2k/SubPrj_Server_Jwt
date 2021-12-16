package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.controller;


import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.authen.UserPrincipal;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.Role;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.Token;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.User;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service.RoleService;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service.TokenService;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service.UserService;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/addRole")
    public Role addNewRole(@RequestBody Role r){
        roleService.addNewRole(r);
        return r;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.createUser(user);
        return "Register successful";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        UserPrincipal userPrincipal =
                userService.findByEmail(user.getEmail());

        if (null == user || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), userPrincipal.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));

        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);

        return ResponseEntity.ok(token.getToken());
    }


    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/hello2")
    @PreAuthorize("hasAnyAuthority('USER') or hasAnyAuthority('ADMIN')")
    public ResponseEntity hello1(){
        return ResponseEntity.ok("hello USER");
    }



}
