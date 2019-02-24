package com.example.springrestdoc.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_memberS")
public class Member {
    @Id
    private String uid;
    private String name;
    private String upw;
}
