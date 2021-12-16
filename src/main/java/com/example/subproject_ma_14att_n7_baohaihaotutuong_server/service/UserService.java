package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service;

import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.authen.UserPrincipal;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.User;



public interface UserService {
    User createUser(User user);
    UserPrincipal findByEmail(String email);
}
