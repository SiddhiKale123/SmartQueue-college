package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.QueueStatusResponse;
import com.example.demo.entity.Queue;
import com.example.demo.repository.QueueRepository;

@Service
public class QueueManagementService {

    private final QueueRepository queueRepository;

    public QueueManagementService(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    // Create a new queue token
    public Queue createToken(Queue queue) {

        Integer nextToken = getNextTokenNumber();

        queue.setTokenNumber(nextToken);
        queue.setStatus("WAITING");

        return queueRepository.save(queue);
    }

    // Get all queue entries
    public List<Queue> getAllQueueEntries() {
        return queueRepository.findAll();
    }

    // Get queue entry by ID
    public Queue getQueueById(Long id) {
        return queueRepository.findById(id).orElse(null);
    }

    // Get complete queue status
    public QueueStatusResponse getQueueStatus(Long id) {

        Queue queue = queueRepository.findById(id).orElse(null);

        if (queue == null) {
            return null;
        }

        int position = getQueuePosition(id);

        return new QueueStatusResponse(
                queue.getTokenNumber(),
                queue.getStudentName(),
                queue.getServiceName(),
                queue.getStatus(),
                position
        );
    }

    // Get position of a student in the queue
    public int getQueuePosition(Long id) {

        Queue selectedQueue = queueRepository.findById(id).orElse(null);

        if (selectedQueue == null) {
            return -1;
        }

        List<Queue> queueList = queueRepository.findAll();

        int position = 0;

        for (Queue queue : queueList) {

            if ("WAITING".equals(queue.getStatus())) {

                position++;

                if (queue.getId().equals(id)) {
                    return position;
                }
            }
        }

        return 0;
    }

    // Call the next student
    public Queue callNextStudent() {

        List<Queue> queueList = queueRepository.findAll();

        for (Queue queue : queueList) {

            if ("WAITING".equals(queue.getStatus())) {

                queue.setStatus("CALLED");

                return queueRepository.save(queue);
            }
        }

        return null;
    }

    // Complete a queue service
    public Queue completeQueueEntry(Long id) {

        Queue queue = queueRepository.findById(id).orElse(null);

        if (queue != null) {

            queue.setStatus("COMPLETED");

            return queueRepository.save(queue);
        }

        return null;
    }

    // Generate next token number
    private Integer getNextTokenNumber() {

        List<Queue> queueList = queueRepository.findAll();

        if (queueList.isEmpty()) {
            return 1;
        }

        Integer maxToken = 0;

        for (Queue queue : queueList) {

            if (queue.getTokenNumber() > maxToken) {
                maxToken = queue.getTokenNumber();
            }
        }

        return maxToken + 1;
    }
}