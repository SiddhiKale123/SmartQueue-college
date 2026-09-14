package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.QueueService;
import com.example.demo.repository.ServiceRepository;

@Service
public class ServiceManagementService {

    private final ServiceRepository serviceRepository;

    public ServiceManagementService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Add a new service
    public QueueService createService(QueueService service) {
        return serviceRepository.save(service);
    }

    // Get all services
    public List<QueueService> getAllServices() {
        return serviceRepository.findAll();
    }

    // Get service by ID
    public QueueService getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    // Update service
    public QueueService updateService(Long id, QueueService service) {

        QueueService existingService =
                serviceRepository.findById(id).orElse(null);

        if (existingService != null) {

            existingService.setName(service.getName());
            existingService.setDescription(service.getDescription());
            existingService.setEstimatedTime(service.getEstimatedTime());
            existingService.setStatus(service.getStatus());

            return serviceRepository.save(existingService);
        }

        return null;
    }

    // Delete service
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}