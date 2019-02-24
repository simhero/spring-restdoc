package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardReplyRepository extends JpaRepository<FreeBoard, Long> {
}
