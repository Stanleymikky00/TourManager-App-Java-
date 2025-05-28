PStA Java Project – Tour Management System

This project is a simplified Object-Oriented Hiking Tour Manager, built in Java, designed to demonstrate core OOP principles like inheritance, interfaces, composition, and greedy algorithms using Hash maps, Comparators, Array List etc.

Key Concept Used:

- Abstract Classes (`Person`)
- Inheritance (`Participant`, `TourGuide` extend `Person`)
- Interfaces (`Tour`)
- Implementation Class (`TourImp implements Tour`)
- Generics & Collections (`List`, `Map`, `ArrayList`, `HashMap`)
- Greedy Algorithm for redistributing luggage
- Markdown export of tour summaries

Features

- Participants and Tour Guides inherit from a shared `Person` class.
- Each participant has a backpack (`List<Item>`), and weight limits based on age.
- Implements a greedy algorithm to redistribute luggage fairly.
- Creates a Markdown report to summarise tours, item assignments, and participants.
- Generates a Markdown

How to Run

Step 1: Open in IntelliJ

Make sure the `build.gradle` and `settings.gradle` files are in your project root.

Step 2: Run the App

Open the Gradle tab, then navigate to:


Tasks > application > run


Double-click `run` to start the app.

Step 3: Run Tests

Navigate to:


Tasks > verification > test


Or right-click `AppTest.java` and select Run.



How Redistribution Works

1. All participants’ items are backed up (`itemsBefore`).
2. All items are pooled and sorted by weight (descending).
3. Participants are sorted by current weight (ascending).
4. Each item is assigned to the lightest person who can carry it.
5. Final backpacks are stored in `itemsAfter`.
6. A Markdown report is generated.



Authors

- Stanley Mike (student at Technische Hochschule Rosenheim)
- Project guided by OOP/OOSD Summer Semester 2025



Notes

- Designed to pass GitLab CI/CD pipelines
- Compatible with Gradle and Java 17
- Markdown + HTML report generation is optional