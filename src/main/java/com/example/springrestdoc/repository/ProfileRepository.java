package com.example.springrestdoc.repository;

import com.example.springrestdoc.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
