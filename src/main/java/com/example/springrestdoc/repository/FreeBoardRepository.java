package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.FreeBoardReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<FreeBoardReply, Long> {
}
