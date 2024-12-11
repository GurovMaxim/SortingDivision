package com.example;

import com.example.GameEngine;

public class Game {
    private GameEngine gameEngine;

    public Game() {
        gameEngine = new GameEngine();
    }

    public void start() {
        gameEngine.start();
    }
}