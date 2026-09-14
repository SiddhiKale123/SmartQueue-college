package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Queue;

public interface QueueRepository extends JpaRepository<Queue, Long> {

}