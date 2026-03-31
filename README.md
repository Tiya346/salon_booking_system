# Java Salon Booking System

A console-based salon appointment manager built in Java as an Object-Oriented Programming course project. The system lets you create hair and skin services, book appointments for customers, cancel bookings, and view a revenue summary  all while demonstrating the four core OOP pillars: **Abstraction**, **Encapsulation**, **Inheritance**, and **Polymorphism**.

---

## Table of Contents

- [Project Structure](#project-structure)
- [OOP Concepts Used](#oop-concepts-used)
- [How Pricing Works](#how-pricing-works)
- [Getting Started](#getting-started)
- [Sample Output](#sample-output)
- [Future Improvements](#future-improvements)

---

## Project Structure

```
SalonBookingSystem/
├── Bookable.java          # Interface booking contract (confirm, cancel, duration)
├── Service.java           # Abstract class shared service fields and abstract methods
├── HairService.java       # Subclass hair-specific pricing and booking logic
├── SkinService.java       # Subclass skin-specific pricing and booking logic
├── Appointment.java       # Data class holds all info for one booking
├── BookingManager.java    # Business logic manages the appointment list
└── Main.java              # Entry point demo of all features
```

---

## OOP Concepts Used

### Abstraction
`Service` is declared `abstract` you cannot create a `Service` object directly. It defines two abstract methods, `calculatePrice()` and `getServiceDetails()`, that every subclass must implement. The `Bookable` interface provides a second layer of abstraction, defining the booking contract independently of the service hierarchy.

### Encapsulation
Every field in every class is `private`. Nothing outside a class can read or modify its fields directly all access goes through getters and setters. This makes state changes easy to trace and keeps each class in control of its own data.

### Inheritance
`HairService` and `SkinService` both extend `Service`. They inherit the shared fields (`serviceName`, `basePrice`, `staffName`) and the concrete `displayInfo()` method, while adding their own type-specific fields and overriding the abstract methods.

### Polymorphism
Both subclasses override `calculatePrice()` with their own pricing logic. When a `Service[]` array holds a mix of `HairService` and `SkinService` objects and `calculatePrice()` is called on each, Java automatically dispatches to the correct version at runtime no `if/else` type-checking needed.

---

## How Pricing Works

**Hair Service**  starts at the base price, then adds:
- `+$10` for medium-length hair
- `+$20` for long hair
- `+$8` if a wash is included

**Skin Service**  starts at the base price, then adds:
- `+$10` for dry skin
- `+$15` for sensitive skin
- `+$25` if premium products are used

---

## Getting Started

### Requirements
- Java JDK 8 or later
- Any IDE (IntelliJ IDEA, VS Code, Eclipse) or just a terminal

### Compile

```bash
javac Bookable.java Service.java HairService.java SkinService.java Appointment.java BookingManager.java Main.java
```

### Run

```bash
java Main
```

All seven files must be in the same directory and compiled together before running.

---

## Sample Output

```
--- Service Details ---
Hair Service - Classic Haircut | Length: short | Wash included: No | Duration: 30 mins | Total Price: $30.0
Hair Service - Blowout and Style | Length: long | Wash included: Yes | Duration: 60 mins | Total Price: $68.0
Skin Service - Basic Facial | Skin type: normal | Products: Standard | Duration: 45 mins | Total Price: $50.0
Skin Service - Deep Hydration Treatment | Skin type: sensitive | Products: Premium | Duration: 90 mins | Total Price: $110.0

--- Polymorphism Demo ---
Classic Haircut costs: $30.0
Blowout and Style costs: $68.0
Basic Facial costs: $50.0
Deep Hydration Treatment costs: $110.0

--- Booking Appointments ---
Hair service 'Classic Haircut' has been confirmed.
Appointment APT001 added for Alice Brown.
...

--- Cancelling Appointment APT002 ---
Skin service 'Basic Facial' has been cancelled.
Appointment APT002 has been cancelled.

Total confirmed revenue: $208.0
Total appointments on record: 4
```

---

## Future Improvements

- Interactive console menu using `Scanner` for real-time user input
- Input validation and error handling for bad data
- A third service type (e.g. `NailService`) to prove extensibility
- JUnit 5 unit tests for pricing logic and appointment lifecycle
- File persistence so appointments survive application restarts
- Status `enum` to replace the current string-based status field

---

## Author

Built as a beginner OOP project in Java. Feel free to fork, extend, and experiment.
