package com.example.springrestdoc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_pds")
@EqualsAndHashCode(of = "pid")
public class PDSBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String pname;
    private String pwriter;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pdsno")
    private List<PDSFile> files;
}
