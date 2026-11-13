# Circus Of Plates

**Circus of Plates** is a Java-based arcade game in which players control a clown who catches falling plates and rings using two sticks. The objective is to collect matching shapes, build stacks, and score as many points as possible before time runs out or a bomb hits the clown.

The game features multiple difficulty levels, colorful graphics, animated falling objects, and an interactive menu system.

## Game Features

- **Three Difficulty Levels:** Easy, Medium, and Hard, each with different falling speeds and spawn intervals.
- **Object Catching:** Move the clown to catch falling plates and rings.
- **Stack Management:** Collect objects on the clown's left and right sticks.
- **Color Matching:** Match three consecutive objects of the same color to clear them and earn points.
- **Bombs:** Avoid falling bombs! Getting hit by one ends the game.
- **Time Limit:** Each round lasts 60 seconds.
- **Pause Menu:** Pause and resume the game, restart the current round, or return to the main menu.
- **Game Over Screen:** Displays the final score and allows players to play again or return to the main menu.
- **Custom Graphics:** Circus-themed backgrounds, character sprites, and object images.

## Controls

| Key | Action |
|---|---|
| ← Left Arrow | Move the clown left |
| → Right Arrow | Move the clown right |
| ESC | Pause / Resume the game |

## 🛠️ Technologies Used

- **Java** – Main programming language.
- **Java Swing & AWT** – Graphical user interface and game menus.
- **Object-Oriented Programming (OOP)** – Classes, inheritance, encapsulation, and polymorphism.
- **Strategy Design Pattern** – Implements the different difficulty levels.
- **Factory Design Pattern** – Creates falling objects such as plates, rings, and bombs.
- **Game Engine:** `engine_v3.jar`

## Setup and Installation

### Prerequisites

- Java Development Kit (JDK).
- Visual Studio Code or another Java IDE.
- The provided `engine_v3.jar` game engine.

### 1. Open the Project

Open the project folder in Visual Studio Code.

Make sure the `lib` folder contains `engine_v3.jar` and that the `resources` folder contains the game images.

### 2. Compile the Project

From the project root directory, run the following command in PowerShell:

```powershell
javac -encoding UTF-8 -cp "lib/engine_v3.jar" -d bin (Get-ChildItem -Recurse src -Filter *.java).FullName
```

### 3. Run the Game

```powershell
java -cp "bin;lib/engine_v3.jar" eg.edu.alexu.csd.oop.circus.Main
```

## How to Play

1. Launch the game to open the main menu.
2. Select your preferred difficulty level.
3. Use the left and right arrow keys to move the clown.
4. Catch falling plates and rings using the clown's sticks.
5. Match three consecutive objects of the same color to clear them and increase your score.
6. Avoid bombs!
7. Try to achieve the highest score before the 60-second timer expires.

Good luck, and enjoy the show!