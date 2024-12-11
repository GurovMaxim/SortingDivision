# Sorting Algorithm Game

This is a Java-based game that challenges users to quickly divide 5-digit numbers and determine if the result is an integer. The game also allows the user to choose a sorting algorithm to sort the list of numbers when they answer incorrectly and more unsorted numbers are added at the end of the list. This Part of the game simulates cases when to sorted database added new unsorted information.

## Design Patterns

The project utilizes the following design patterns:

1. **Factory Pattern**: The `SortingAlgorithmFactory` class is responsible for creating instances of the different sorting algorithm implementations. This pattern promotes flexibility and extensibility, as new sorting algorithms can be added without modifying the `GameEngine` class.

2. **Strategy Pattern**: The `SortingAlgorithm` interface and its implementations (Quicksort and Timsort) allow the user to choose the sorting algorithm at runtime. This pattern adheres to the Open/Closed Principle, as the `GameEngine` can use different sorting algorithms without being modified.

3. **Observer Pattern**: The `ObserverManager` and `Observer` interface enable the game to notify interested parties (like the `ScoreObserver`) about changes in the game state. This pattern promotes loose coupling and flexibility, as new observers can be added without modifying the `GameEngine` class.

## Sorting Algorithms

The game currently offers two sorting algorithm options:

1. **Quicksort**:
    - Quicksort is a comparison-based sorting algorithm that follows the divide-and-conquer paradigm.
    - It has an average time complexity of O(n log n), making it an efficient choice for sorting large datasets.
    - Quicksort was chosen for this game due to its general efficiency and widespread use in practice.

2. **Timsort**:
    - Timsort is a hybrid sorting algorithm that combines the strengths of Insertion Sort and Merge Sort.
    - It is designed to handle partially-sorted data efficiently, which is particularly relevant for this game scenario where new unsorted data is added to the list over time.
    - Timsort has a time complexity of O(n log n) in the average and worst cases, making it a suitable alternative to Quicksort.

## Project Structure

The project is organized into the following packages and classes:

- `com.example.designpatterns`
    - `Game.java`: The entry point of the application, which creates and starts the `GameEngine`.
    - `GameEngine.java`: Handles the game logic, including user input, game loop, and score tracking.
    - `SortingAlgorithmFactory.java`: Responsible for creating instances of the different sorting algorithm implementations.
    - `SortingAlgorithm.java`: Interface defining the contract for sorting algorithm implementations.
    - `QuicksortAlgorithm.java`: Implements the Quicksort algorithm.
    - `TimsortAlgorithm.java`: Implements the Timsort algorithm.
    - `ObserverManager.java`: Manages the registration and notification of observers.
    - `ScoreObserver.java`: Implements the `Observer` interface to observe and display the user's score.
    - `ProgressObserver.java`: Implements the `Observer` interface to observe and display the user's progress.

## How to Run the Game

1. Ensure you have Java 8 or higher installed on your system.
2. Clone the repository and navigate to the project directory.
3. Compile the Java files using the command: `javac com/example/designpatterns/*.java`.
4. Run the game using the command: `java com.example.designpatterns.Game` or just Run "Main.java."
5. Follow the prompts to choose a sorting algorithm and play the game.

## Contributions

Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.