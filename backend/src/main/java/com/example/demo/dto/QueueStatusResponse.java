package com.example.demo.dto;

public class QueueStatusResponse {

    private Integer tokenNumber;
    private String studentName;
    private String serviceName;
    private String status;
    private int position;

    public QueueStatusResponse(
            Integer tokenNumber,
            String studentName,
            String serviceName,
            String status,
            int position) {

        this.tokenNumber = tokenNumber;
        this.studentName = studentName;
        this.serviceName = serviceName;
        this.status = status;
        this.position = position;
    }

    public Integer getTokenNumber() {
        return tokenNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getStatus() {
        return status;
    }

    public int getPosition() {
        return position;
    }
}