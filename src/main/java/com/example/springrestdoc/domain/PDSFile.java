package com.example.springrestdoc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_pdsfiles")
@EqualsAndHashCode(of = "fno")
public class PDSFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;
    private String pdsfile;

}
