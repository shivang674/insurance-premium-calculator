# Insurance Premium Calculator & Claim Validator (Core Java)

A Core Java console-based application that simulates insurance underwriting and claim validation logic commonly used in fintech insurance systems.

This project focuses on business rules, clean object-oriented design, and strong Java fundamentals without using any frameworks.

## Features

### Insurance Premium Calculation
Calculates insurance premium using rule-based risk assessment.

**Risk factors considered:**
* Age
* Annual income
* Smoking habits
* Pre-existing medical conditions

**Classifies customers into:**
* LOW
* MEDIUM
* HIGH risk categories

### Claim Validation
Validates insurance claims based on:
* Policy status (assumed active)
* Waiting period completion
* Coverage amount limits

Approves or rejects claims based on defined business rules.

### User Interaction
* Takes real-time customer input via the console
* Uses yes/no input instead of true/false for better usability
* Performs basic input validation for numeric fields

### File Persistence
* Saves policy details to a text file using Java I/O
* Demonstrates persistence without using a database

## Tech Stack
* **Language:** Java (Core Java)
* **Concepts Used:**
    * Object-Oriented Programming (Encapsulation, Separation of Concerns)
    * Enums
    * Java Date and Time API
    * File Handling (I/O)
    * Console Input using Scanner

## Project Structure
```text
insurance-system/
│
├── model/
│   ├── Customer.java
│   ├── Policy.java
│   └── Claim.java
│
├── service/
│   ├── PremiumCalculator.java
│   └── ClaimValidator.java
│
├── enums/
│   ├── PolicyType.java
│   ├── RiskLevel.java
│   └── ClaimStatus.java
│
└── Main.java
```

## How to Run the Project

### Using Terminal or Command Prompt

1. **Clone the repository:**
   ```bash
   git clone https://github.com/shivang674/insurance-premium-calculator.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd insurance-premium-calculator
   ```

3. **Compile the project:**
   ```bash
   javac *.java enums/*.java model/*.java service/*.java
   ```

4. **Run the application:**
   ```bash
   java Main
   ```

## How to Test
1. Enter valid customer details when prompted.
2. Try different combinations of age, income, smoking habits, and diseases to observe changes in risk level and premium.
3. Enter a claim amount greater than coverage to test claim rejection.
4. Check the generated `policy-details.txt` file for saved policy records.

## Design Decisions
* Business logic is separated from data models to maintain clean code structure.
* Enums are used to prevent invalid values and improve type safety.
* The project avoids frameworks to strengthen Core Java fundamentals.
* Policy status is assumed active to keep the focus on underwriting and claim logic.

## Future Improvements
* Add database integration.
* Implement policy expiry logic.
* Add exception handling and logging.
* Convert the application into a REST API using Spring Boot.

## Author
**Shivang Chaudhary**