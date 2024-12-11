package com.example;

import com.example.Observer;

public class ScoreObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}