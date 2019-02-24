package com.example.springrestdoc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "tabl_board_reply")
@EqualsAndHashCode(of = "rno")
public class FreeBoardReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    private String reply;
    private String replyer;

    @ManyToOne
    private FreeBoard freeBoard;

    @CreationTimestamp
    private Timestamp replydate;
    @UpdateTimestamp
    private Timestamp updatedate;
}
