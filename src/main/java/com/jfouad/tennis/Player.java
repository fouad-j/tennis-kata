package com.jfouad.tennis;

import com.jfouad.tennis.exceptions.UndefinedPlayerNameException;

import static java.util.Objects.isNull;

class Player {
    private String name;
    private int score;

    public Player(String name) {
        if (isNull(name) || name.isBlank()) {
            throw new UndefinedPlayerNameException("Player name couldn't be null");
        }

        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void scores() {
        this.score++;
    }
}
