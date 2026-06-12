# Chat App - Registration and Login System

## Author
Sinethemba Sithole

## Date
June 2026

## Description
This is a Chat App with registration, login, message sending, and stored messages features.

## Features

### Part 1 - Registration & Login
- User registration with validation
- User login
- Username validation (must contain _ and be ≤ 5 characters)
- Password validation (8+ chars, capital letter, number, special character)
- Phone number validation (must start with +27 and have 9 digits)

### Part 2 - Send Messages
- Message sending with hash generation
- Message ID (10 digit random number)
- Message Hash format (00:0:HITHANKS)
- Phone number validation for recipient
- Message length validation (max 250 chars)
- Options: Send, Delete, or Store message
- JUnit tests for all methods

### Part 3 - Stored Messages
- Arrays for sent, stored, and disregarded messages
- Display sender and recipient of stored messages
- Find and display the longest stored message
- Search for a message by ID
- Search for all messages for a specific recipient
- Delete a message using message hash
- Display full report of all stored messages
- Save messages to JSON file (messages.json)
- GitHub Actions for automated testing (CI/CD)

## How to Run
1. Open project in NetBeans
2. Run Poepart1.java
3. Register a new account
4. Login
5. Choose from menu:
   - Option 1: Send Messages
   - Option 2: Coming Soon
   - Option 3: Stored Messages (Part 3)
   - Option 4: Quit

## Test Data

### Registration Test Data
| Field | Example |
|-------|---------|
| First Name | Sinethemba |
| Last Name | Sithole |
| Username | sin_9 |
| Password | Sithol_@9 |
| Phone | +27799495626 |

### Message Test Data (Part 3)
| Message | Recipient | Message Text | Status |
|---------|-----------|--------------|--------|
| 1 | +27834557896 | "Did you get the cake?" | Sent |
| 2 | +27838884567 | "Where are you? You are late! I have asked you to be on time." | Stored |
| 3 | +27834484567 | "Yohoooo, I am at your gate." | Disregard |
| 4 | 0838884567 | "It is dinner time!" | Sent |
| 5 | +27838884567 | "Ok, I am leaving without you." | Stored |

## Technologies Used
- Java
- JUnit 5 (Unit Testing)
- Git & GitHub (Version Control)
- GitHub Actions (CI/CD)
- JSON (Data Storage)

## Test Results
All JUnit tests passed successfully:
- Part 1: accountTest.java (8 tests)
- Part 2: MessageTest.java (5 tests)
- Part 3: MessageTest.java (6 additional tests)
- **Total: 19 tests passing**

## GitHub Repository
https://github.com/ST10465847/poepart1part-1

## Branches
- `main` - Production ready code
- `KhanbanTasks` - Feature branch (assignment requirement)

## References
- GeeksforGeeks. (2026). Java Arrays.
- GeeksforGeeks. (2026). Java JSON Parsing.
- JUnit Team. (2026). JUnit 5 User Guide.
