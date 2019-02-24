package com.example.springrestdoc.repository;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Log
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testFetchJoin1() {
        List<Object[]> result = memberRepository.getMemberWithPRofileCount("USER1");
        result.forEach( arr -> {
            log.info("arr = "+Arrays.toString(arr));
        });
    }

    @Test
    public void testFetchJoin2() {
        List<Object[]> result = memberRepository.getMemberWithPRofile("USER1");
        result.forEach(arr ->{
            log.info("arr =" + Arrays.toString(arr));
        });

    }
}