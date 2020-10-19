package com.jfouad.tennis;

import static com.jfouad.tennis.Score.getScoreLabel;

public class TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(String namePlayerOne, String namePlayerTwo) {
        this.playerOne = new Player(namePlayerOne, 0);
        this.playerTwo = new Player(namePlayerTwo, 0);
    }

    public String getScore() {
        if (playerOne.getScore() == 0 && playerTwo.getScore() == 0) {
            return getScoreLabel(0) + " - " + getScoreLabel(0);
        }

        if (playerOne.getScore() >= 3 && playerOne.getScore() == playerTwo.getScore()) {
            return "Deuce";
        }

        if (playerOne.getScore() == playerTwo.getScore()) {
            return getScoreLabel(playerOne.getScore()) + " - " + getScoreLabel(playerTwo.getScore());
        }

        if(playerOne.getScore() > 3 && playerOne.getScore() == playerTwo.getScore() + 1) {
            return "Advantage " + playerOne.getName();
        }

        if(playerTwo.getScore() > 3 && playerTwo.getScore() == playerOne.getScore() + 1) {
            return "Advantage " + playerTwo.getName();
        }

        return null;
    }

    public void playerOneScores() {
        this.playerOne.scores();
    }

    public void playerTwoScores() {
        this.playerTwo.scores();
    }

}

