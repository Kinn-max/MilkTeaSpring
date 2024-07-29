package com.javaweb.entity;

import javax.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "role")
@Entity
public class Role extends DateOfCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> userList = new ArrayList<>();
    public static String ADMIN = "ADMIN";
    public static String STAFF = "STAFF";
    public static String USER = "USER";
}
