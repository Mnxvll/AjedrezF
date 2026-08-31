# Console Chess Game

This is a simple console-based chess game developed in Java. 
It features a text interface where players interact with the board using algebraic-style coordinates (e.g., X and Y).

## How to Play

1. Run the `Main.java` class located in the `src/main/java/View` directory.
2. The game will display the initial board state.
3. Players take turns entering the X (Letter) and Y (Number) coordinates of the piece they want to move, followed by the target coordinates.
4. The game verifies the move according to standard chess rules and updates the board.
5. Invalid moves or attempts to capture your own pieces will result in an error message.
6. The game continues until a win condition is met (capturing the opponent's king).

## Structure

* **View**: Contains the main execution loop and handles the console input/output rendering (`Main.java`).
* **Logic**: Contains the implementation of the `Board`, the abstract `Piece`, and the individual piece subclasses (`King`, `Queen`, `Rook`, `Bishop`, `Knight`, `Pawn`) along with their movement verification logic.
* **Controller**: Acts as an intermediary to process inputs and trigger logic state changes (`ControllerA.java`).

## Requirements

* Java Development Kit (JDK) 8 or higher
* Maven (for running tests)

## Running Tests

To run the automated tests for the piece movement logic, execute:

```bash
mvn test
```
