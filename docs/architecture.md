# SmartQueue System Architecture

## Overview

SmartQueue is a digital queue and student service management
system designed for the college Student Section.

## Users

- Student
- Staff
- Admin

## Technology Architecture

Student / Staff / Admin
        ↓
React.js Frontend
        ↓
REST APIs
        ↓
Spring Boot Backend
        ↓
Spring Security + JWT
        ↓
Service Layer
        ↓
JPA / Hibernate
        ↓
MySQL Database

## Main Modules

- Authentication
- Student Services
- Token Management
- Queue Management
- Staff Management
- Admin Management
- Notifications
- Waiting Time Prediction

## Future AI Module

Historical queue data will be used to develop a
waiting-time prediction model.