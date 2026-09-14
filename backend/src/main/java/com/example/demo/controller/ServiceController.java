package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.QueueService;
import com.example.demo.service.ServiceManagementService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceManagementService serviceManagementService;

    public ServiceController(ServiceManagementService serviceManagementService) {
        this.serviceManagementService = serviceManagementService;
    }

    // Create a new service
    @PostMapping
    public QueueService createService(@RequestBody QueueService service) {
        return serviceManagementService.createService(service);
    }

    // Get all services
    @GetMapping
    public List<QueueService> getAllServices() {
        return serviceManagementService.getAllServices();
    }

    // Get service by ID
    @GetMapping("/{id}")
    public ResponseEntity<QueueService> getServiceById(@PathVariable Long id) {

        QueueService service = serviceManagementService.getServiceById(id);

        if (service != null) {
            return ResponseEntity.ok(service);
        }

        return ResponseEntity.notFound().build();
    }

    // Update service
    @PutMapping("/{id}")
    public ResponseEntity<QueueService> updateService(
            @PathVariable Long id,
            @RequestBody QueueService service) {

        QueueService updatedService =
                serviceManagementService.updateService(id, service);

        if (updatedService != null) {
            return ResponseEntity.ok(updatedService);
        }

        return ResponseEntity.notFound().build();
    }

    // Delete service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {

        QueueService service =
                serviceManagementService.getServiceById(id);

        if (service != null) {
            serviceManagementService.deleteService(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}