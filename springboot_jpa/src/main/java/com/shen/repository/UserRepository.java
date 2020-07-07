package com.shen.repository;

import com.shen.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<user,Long> {
    public List<user> findAll();
}

