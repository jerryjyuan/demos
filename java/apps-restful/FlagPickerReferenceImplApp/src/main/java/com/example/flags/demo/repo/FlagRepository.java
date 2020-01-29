package com.example.flags.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flags.demo.model.Flag;

public interface FlagRepository extends JpaRepository<Flag, Long> {

}

