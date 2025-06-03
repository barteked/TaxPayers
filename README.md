# TaxPayers

## Project Description

**TaxPayers** is a Java application designed to model a tax calculation system for citizens of the fictional country Nibylandia.

The application enables officials to generate reports detailing how much tax each citizen should pay, based on their tax status and monthly earnings.

---

## Features

- Supports multiple tax calculation strategies depending on the citizen’s status:
  - Single without children (39% tax on annual income)
  - In a relationship without children (25% tax)
  - In a relationship with children (20% tax)

- Easily extensible with new tax strategies using the **Strategy design pattern**.

- Generates reports including:
  - Citizen’s first and last name
  - Annual income
  - Amount of tax due

---

## Architecture and Key Classes

- **`Citizen`** – represents a citizen of Nibylandia, stores personal data and monthly earnings, delegates tax calculation to a strategy.

- **`TaxStrategy`** – interface defining the method `calculateTax(BigDecimal annualEarnings)`.

- Concrete implementations of `TaxStrategy`:
  - `TaxSingle`
  - `TaxChildlessRelationship`
  - `TaxRelationshipWithChildren`

- **`Official`** – class responsible for generating reports for individual citizens.

---

## Technologies and Tools

- Java programming language
- Gradle build system
- JUnit 5 and Mockito for unit testing
- Strategy design pattern for flexible tax calculation rules

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/barteked/TaxPayers.git
