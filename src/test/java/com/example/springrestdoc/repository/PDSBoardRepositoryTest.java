package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.PDSBoard;
import com.example.springrestdoc.domain.PDSFile;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@Slf4j
@SpringBootTest
@Commit
public class PDSBoardRepositoryTest {

    @Autowired
    private PDSBoardRepository pdsBoardRepository;

    @Test
    public void testInsertPDSBoard() {
        PDSBoard pdsBoard = new PDSBoard();
        pdsBoard.setPname("Document");

        PDSFile pdsFile1 = new PDSFile();
        pdsFile1.setPdsfile("file1.doc");
        PDSFile pdsFile2 = new PDSFile();
        pdsFile2.setPdsfile("file2.doc");

        pdsBoard.setFiles(Arrays.asList(pdsFile1,pdsFile2));

        log.info("try to save pds");
        pdsBoardRepository.save(pdsBoard);
    }

    @Transactional
    @Test
    public void testUpdateFileName() {
        Long fno = 1L;
        String newName = "updateFile1.doc";
        int count = pdsBoardRepository.updatePDSFile(fno, newName);

        log.info("update count :" + count);
    }

    @Transactional
    @Test
    public void testUpdateFileName2() {
        String newNAme = "updateFile2.doc";
        Optional<PDSBoard> result = pdsBoardRepository.findById(2L);

        result.ifPresent((pdsBoard -> {
            log.info("데이타가 존재하므로 update 시도");
            PDSFile target = new PDSFile();
            target.setFno(2L);
            target.setPdsfile(newNAme);

            log.info("pdsBoard= {}",pdsBoard);

            int idx = pdsBoard.getFiles().indexOf(target);
            log.info("idx=" + idx);
            if (idx > -1) {
                List<PDSFile> list = pdsBoard.getFiles();
                list.remove(idx);
                list.add(target);
                pdsBoard.setFiles(list);
            }
            pdsBoardRepository.save(pdsBoard);
        }));

    }

    @Transactional
    @Test
    public void testDeleteFile() {
        Long fno = 2L;

        int count = pdsBoardRepository.deletePDSBoardss(fno);
        log.info("DELETE PSDFile :" + count);

    }

    @Transactional
    @Test
    public void insertDummies() {
        List<PDSBoard> list = new ArrayList<>();

        IntStream.range(1,100).forEach( i -> {

            PDSBoard pdsBoard = new PDSBoard();
            pdsBoard.setPname("자료 " + i);

            PDSFile pdsFile1 = new PDSFile();
            pdsFile1.setPdsfile("file1.doc");
            PDSFile pdsFile2 = new PDSFile();
            pdsFile2.setPdsfile("file2.doc");
            pdsBoard.setFiles(Arrays.asList(pdsFile1,pdsFile2));

            log.info("try to save pds");

            list.add(pdsBoard);
        });

        pdsBoardRepository.saveAll(list);
    }

    @Transactional
    @Test
    public void viewSummary() {
        pdsBoardRepository.getSummary().forEach( arr ->{
            log.info(Arrays.toString(arr));
        });
    }
}