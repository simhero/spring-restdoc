package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.PDSBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PDSBoardRepository extends JpaRepository<PDSBoard, Long> {

    @Modifying
    @Query(" UPDATE FROM PDSFile f set f.pdsfile =?2 WHERE f.fno= ?1 ")
    public int updatePDSFile(Long fno, String newFileName);

    @Modifying
    @Query("DELETE FROM PDSFile f where f.fno =?1")
    public int deletePDSBoardss(Long fno);

    @Query("SELECT p, count(f) from PDSBoard  p left outer join p.files f where p.pid >0 group by p order by p.pid desc")
    public List<Object[]> getSummary();

}
