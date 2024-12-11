package com.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private SortingAlgorithmFactory sortingAlgorithmFactory;
    private SortingAlgorithm sortingAlgorithm;
    private ObserverManager observerManager;
    private List<Integer> numbers;
    private long totalDivisionTime;
    private long totalSortingTime;
    private long totalGameTime;
    private int correctAnswers;
    private int incorrectAnswers;
    private long bestTotalTime = Long.MAX_VALUE;

    public GameEngine() {
        sortingAlgorithmFactory = new SortingAlgorithmFactory();
        observerManager = new ObserverManager();
        observerManager.addObserver(new ScoreObserver());
        numbers = generateNumbers(50000);
    }

    public void start() {
        // Prompt user to choose sorting algorithm
        promptSortingAlgorithm();
        correctAnswers = 0;

        // Start game timer
        Instant gameStart = Instant.now();

        // com.example.Game loop
        for (int i = 0; i < 10; i++) {
            processRound();
        }

        // Calculate final game time
        Instant gameEnd = Instant.now();
        totalGameTime = Duration.between(gameStart, gameEnd).toMillis();

        // Calculate final score
        long finalScore = totalDivisionTime + totalSortingTime;
        notifyObservers("Final score: " + finalScore + "ms");
        notifyObservers("Total division time: " + totalDivisionTime + "ms");
        notifyObservers("Total sorting time: " + totalSortingTime + "ms");
        notifyObservers("Total game time: " + totalGameTime + "ms");
        notifyObservers("Incorrect answers: " + incorrectAnswers);
        notifyObservers("Sorting algorithm used: " + sortingAlgorithm.getName());

        // Update best total time
        updateBestTotalTime(finalScore);
    }

    private void promptSortingAlgorithm() {
        boolean validInput = false;
        do {
            System.out.print("Choose a sorting algorithm (Q for Quicksort, T for Timsort): ");
            String input = new Scanner(System.in).nextLine().toUpperCase();
            if (input.length() == 1 && (input.charAt(0) == 'Q' || input.charAt(0) == 'T')) {
                char algorithmChoice = input.charAt(0);
                setSortingAlgorithm(algorithmChoice);
                validInput = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!validInput);
    }

    private void setSortingAlgorithm(char algorithmChoice) {
        switch (algorithmChoice) {
            case 'Q':
                sortingAlgorithm = sortingAlgorithmFactory.createSortingAlgorithm("quicksort");
                break;
            case 'T':
                sortingAlgorithm = sortingAlgorithmFactory.createSortingAlgorithm("timsort");
                break;
        }
    }

    private void processRound() {
        System.out.println("\nNumber of current numbers: " + numbers.size());
        int randomNumber = generateRandomNumber();
        int divisor = generateRandomDivisor();
        System.out.print("Divide " + randomNumber + " by " + divisor + ". Type 'y' if the result is an integer, 'n' if not: ");
        Instant divisionStart = Instant.now();
        String answer = new Scanner(System.in).nextLine();
        Instant divisionEnd = Instant.now();
        totalDivisionTime += Duration.between(divisionStart, divisionEnd).toMillis();

        boolean isInteger = isDivisibleBy(randomNumber, divisor);
        if ((answer.equals("y") && isInteger) || (answer.equals("n") && !isInteger)) {
            correctAnswers++;
        } else {
            incorrectAnswers++;
            System.out.println("Sorting the list...");
            Instant sortStart = Instant.now();
            sortingAlgorithm.sort(numbers);
            Instant sortEnd = Instant.now();
            totalSortingTime += Duration.between(sortStart, sortEnd).toMillis(); // Correct the calculation
            System.out.println("Sorting completed.");

            int addIfWrongAnswer = 5000;
            for (int j = 0; j < addIfWrongAnswer; j++) {
                numbers.add(generateRandomNumber());
            }

            notifyObservers("Incorrect answer. List sorted and new numbers added.");
        }
    }

    private void notifyObservers(String message) {
        observerManager.notifyObservers(message);
    }

    private List<Integer> generateNumbers(int count) {
        List<Integer> generatedNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            generatedNumbers.add((int) (Math.random() * 90000) + 10000);
        }
        return generatedNumbers;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 90000) + 10000;
    }

    private int generateRandomDivisor() {
        int[] divisors = {3, 4, 9};
        return divisors[(int) (Math.random() * divisors.length)];
    }

    private boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    private void updateBestTotalTime(long finalScore) {
        if (finalScore < bestTotalTime) {
            bestTotalTime = finalScore;
            notifyObservers("New best total time: " + bestTotalTime + "ms");
        }
    }
}
