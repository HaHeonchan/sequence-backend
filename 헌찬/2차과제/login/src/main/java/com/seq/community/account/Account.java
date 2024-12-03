package com.seq.community.account;

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

    @Column(nullable = false, unique = true)
    public String userId;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public String password;


}
