package com.seq.community.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String writer;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public String content;

    public String date;
}
