# SmartQueue Database Design

## Main Tables

1. users
2. students
3. staff
4. services
5. counters
6. tokens
7. notifications
8. queue_history

## Main Relationships

- User has one Student or Staff profile.
- Student can have multiple Tokens.
- Service can have multiple Tokens.
- Service can be assigned to Counters.
- Staff can operate Counters.
- User can receive multiple Notifications.
- Service can have multiple Queue History records.

## Token Status

- WAITING
- CALLED
- IN_PROGRESS
- COMPLETED
- CANCELLED
- NO_SHOW