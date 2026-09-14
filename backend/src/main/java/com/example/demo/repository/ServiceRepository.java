package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.QueueService;

public interface ServiceRepository extends JpaRepository<QueueService, Long> {

}