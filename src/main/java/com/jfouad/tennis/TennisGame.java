package com.jfouad.tennis;

import static com.jfouad.tennis.Score.ZERO;

public class TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(String namePlayerOne, String namePlayerTwo) {
        this.playerOne = new Player(namePlayerOne, 0);
        this.playerTwo = new Player(namePlayerTwo, 0);
    }

    public GameStatus getScore() {
        return null;
    }

    public void playerOneScores() {
        this.playerOne.scores();
    }

    public void playerTwoScores() {
        this.playerTwo.scores();
    }


}

