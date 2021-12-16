package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.service;

import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity.Role;
import com.example.subproject_ma_14att_n7_baohaihaotutuong_server.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addNewRole(Role r){
        roleRepository.save(r);
        return r;
    }
}
