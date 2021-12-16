package com.example.subproject_ma_14att_n7_baohaihaotutuong_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role extends BaseEntity {

    private String roleName;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();


}
