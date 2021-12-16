package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.repository;

import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
