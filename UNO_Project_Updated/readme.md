<!-- UNO Game Implementation - README

Overview

This project is a full implementation of the popular card game UNO in Java. The implementation follows Object-Oriented Programming (OOP) principles such as encapsulation, inheritance, and polymorphism. The project uses Maven as the build automation tool to manage dependencies, compilation, and testing.

Table of Contents

Features

Project Structure

Installation and Setup

Gameplay

Maven Dependencies

Testing

Future Enhancements

Contributing

License

Contact

Features

Playable version of UNO, including the standard rules such as Skip, Reverse, Draw Two, and Wild Cards.

A fully functional scoring system, including penalties for failing to declare UNO.

Automated management of player turns, including reversing the play direction and skipping players.

Maven-based project for easy build and dependency management.

Unit testing using JUnit and Mockito.

Project Structure

The project follows a modular approach, with separate classes for different components of the game to ensure easy maintainability and scalability.

Key Files

Card.java: Abstract class representing a generic UNO card.

NumberCard.java: Subclass representing the numbered cards.

ActionCard.java: Subclass representing action cards like Skip, Reverse, and Draw Two.

WildCard.java: Subclass representing Wild and Draw Four cards.

Deck.java: Manages the creation, shuffling, and dealing of cards.

Player.java: Represents a player, managing their hand of cards, score, and actions like declaring UNO.

Game.java: Controls the overall game flow, turn management, and implementation of game rules.

Main.java: Entry point for the application where the game is started.

pom.xml: Maven configuration file for managing dependencies and build configurations.

Installation and Setup

Prerequisites

Java 1.8 or higher

Apache Maven

Steps to Run

Clone the Repository

git clone <repository-url>

Navigate to the Project Directory

cd uno-game

Build the Project using Maven

mvn clean install

Run the Application

mvn exec:java -Dexec.mainClass="com.example.Main"

Gameplay

The game starts with 2-4 players.

Players take turns playing cards that match the color or value of the current card.

Special Cards include:

Skip: Skips the next player's turn.

Reverse: Reverses the direction of play.

Draw Two: Forces the next player to draw two cards.

Wild: Allows the player to choose a new color.

Wild Draw Four: Forces the next player to draw four cards and allows the player to choose a new color.

Players must declare "UNO" when they have only one card left, or face a penalty.

The game ends when one player has no cards left, and scores are calculated.

Maven Dependencies

The project uses the following dependencies:

JUnit (version 4.13.2) - For unit testing.

Apache Commons Lang (version 3.12.0) - For utility methods.

Mockito (version 3.11.2) - For mocking in unit tests.

JavaFX Maven Plugin (version 0.0.5) - For potential GUI support.

These dependencies are specified in the pom.xml file and are automatically managed by Maven.

Testing

Unit tests are written using JUnit and Mockito. To run the tests, execute:

mvn test

Future Enhancements

Graphical User Interface (GUI): Adding a graphical interface to make gameplay more user-friendly.

Online Multiplayer: Enabling network-based multiplayer functionality.

Improved AI: Adding AI players to compete against human players.

Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any new features or bug fixes.

License

This project is licensed under the MIT License.

Contact

For any questions or suggestions, please contact:

Author: 

Email: 
 -->
