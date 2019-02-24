package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.FreeBoard;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@Slf4j
@Commit
@SpringBootTest
public class FreeBoardRepositoryTest {

    @Autowired
    private FreeBoardRepository freeBoardRepository;
    @Autowired
    private FreeBoardReplyRepository freeBoardReplyRepository;

    @Test
    @Transactional
    public void testInsertDummy() {
        IntStream.range(1,100).forEach(i ->{
            FreeBoard freeBoard = new FreeBoard();
            freeBoard.setTitle("Free Board ...." + i);
            freeBoard.setCotent("Free Contents ..." + i);
            freeBoard.setWriter("user" + i%10);
            freeBoardRepository.save(freeBoard);
//            freeBoardRepository.save(freeBoard);

        });
    }
}