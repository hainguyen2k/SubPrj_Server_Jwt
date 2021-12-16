package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.authen;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
public class UserPrincipal implements UserDetails{
    private Long userId;
    private String username;
    private String password;
    private String email;
    private Collection authorities;


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
