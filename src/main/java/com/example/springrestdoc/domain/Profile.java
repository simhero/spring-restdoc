package com.example.springrestdoc.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;
    private String fname;
    private boolean current;

    @ManyToOne
    private Member member;

}
