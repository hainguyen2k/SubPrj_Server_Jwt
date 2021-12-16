package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.repository;

import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface UserRepository extends JpaRepository<User, Long> {
    //User findByUsername(String username);
    User findByEmail(String email);
}
