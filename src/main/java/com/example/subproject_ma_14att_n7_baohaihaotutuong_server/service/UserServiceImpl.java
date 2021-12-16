package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service;


import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.authen.UserPrincipal;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.Role;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.User;

import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.repository.RoleRepository;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user) {
        Role r;
        try {
            List<User> listUser = userRepository.findAll();

            if(listUser.size() == 0){
                r = roleRepository.getById(1L);
                user.getRoles().add(r);
            }else{
                r = roleRepository.getById(2L);
                user.getRoles().add(r);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        userRepository.save(user);

        return user;
    }

    @Override
    public UserPrincipal findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        UserPrincipal userPrincipal = new UserPrincipal();

        if (null != user) {

            Set<String> authorities = new HashSet<>();

            if (null != user.getRoles())

                user.getRoles().forEach(r -> {
                    authorities.add(r.getRoleName());

                });

            userPrincipal.setUserId(user.getId());
            userPrincipal.setUsername(user.getUsername());
            userPrincipal.setEmail(user.getEmail());
            userPrincipal.setPassword(user.getPassword());
            userPrincipal.setAuthorities(authorities);

        }

        return userPrincipal;
    }
}
