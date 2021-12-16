package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service;

import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
