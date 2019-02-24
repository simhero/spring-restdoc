package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("SELECT m.uid, count(p) FROM Member m LEFT OUTER JOIN  Profile  p ON m.uid=p.member WHERE m.uid =?1 GROUp BY m ")
    public List<Object[]> getMemberWithPRofileCount(String uid);

    @Query("SELECT m,p FROM Member m LEFT OUTER JOIN  Profile  p ON m.uid=p.member WHERE m.uid =?1  and p.current=true ")
    public List<Object[]> getMemberWithPRofile(String uid);
}
