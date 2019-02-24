package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.Member;
import com.example.springrestdoc.domain.Profile;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@Log
@SpringBootTest
public class ProfileRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void testInsertMember() {
        IntStream.rangeClosed(1,10).forEach(i -> {
            Member member = new Member();
            member.setUid("USER" + i);
            member.setUpw("PW" + i + "PW");
            member.setName("사용자"+ i);
            memberRepository.save(member);
        });

    }

    @Test
    public void testInsertProfile() {
        Member member = new Member();
        member.setUid("USER1");

        IntStream.rangeClosed(1,10).forEach(i ->{
            Profile profile = new Profile();
            profile.setFname("face"+i+".jpg");
            if(i==1) profile.setCurrent(true);
            profile.setMember(member);
            profileRepository.save(profile);
        });
    }
}