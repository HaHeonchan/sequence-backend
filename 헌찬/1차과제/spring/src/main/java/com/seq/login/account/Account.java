package com.seq.login.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // 기본 정보
    @Column(nullable = false, unique = true)
    public String userId;

    @Column(nullable = false)
    public String username;
    @Column(nullable = false)
    public String password;


}
