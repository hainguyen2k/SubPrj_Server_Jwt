package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service;

import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.Token;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService{
    @Autowired
    private TokenRepository tokenRepository;
    @Override
    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
