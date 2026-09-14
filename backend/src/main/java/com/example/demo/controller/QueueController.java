package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Queue;
import com.example.demo.service.QueueManagementService;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    private final QueueManagementService queueManagementService;

    public QueueController(QueueManagementService queueManagementService) {
        this.queueManagementService = queueManagementService;
    }

    // Generate a new token
    @PostMapping("/token")
    public Queue createToken(@RequestBody Queue queue) {
        return queueManagementService.createToken(queue);
    }

    // Get all queue entries
    @GetMapping
    public List<Queue> getAllQueueEntries() {
        return queueManagementService.getAllQueueEntries();
    }

    // Get queue entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<Queue> getQueueById(@PathVariable Long id) {

        Queue queue = queueManagementService.getQueueById(id);

        if (queue != null) {
            return ResponseEntity.ok(queue);
        }

        return ResponseEntity.notFound().build();
    }

    // Call the next student
    @PostMapping("/call-next")
    public ResponseEntity<Queue> callNextStudent() {

        Queue queue = queueManagementService.callNextStudent();

        if (queue != null) {
            return ResponseEntity.ok(queue);
        }

        return ResponseEntity.noContent().build();
    }

    // Complete a queue service
    @PutMapping("/{id}/complete")
    public ResponseEntity<Queue> completeQueueEntry(@PathVariable Long id) {

        Queue queue = queueManagementService.completeQueueEntry(id);

        if (queue != null) {
            return ResponseEntity.ok(queue);
        }

        return ResponseEntity.notFound().build();
    }
}