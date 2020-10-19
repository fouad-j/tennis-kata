package com.jfouad.tennis;

import java.util.function.BiPredicate;

import static com.jfouad.tennis.Score.getScoreLabel;

public class TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(String namePlayerOne, String namePlayerTwo) {
        this.playerOne = new Player(namePlayerOne, 0);
        this.playerTwo = new Player(namePlayerTwo, 0);
    }

    private final BiPredicate<Player, Player> isPlayerHasAdvantage = (playerOne, playerTwo) -> playerOne.getScore() > 3 && playerOne.getScore() == playerTwo.getScore() + 1;
    private final BiPredicate<Player, Player> isDeuceScore = (playerOne, playerTwo) -> playerOne.getScore() >= 3 && playerOne.getScore() == playerTwo.getScore();
    private final BiPredicate<Player, Player> isLoveScore = (playerOne, playerTwo) -> playerOne.getScore() == 0 && playerTwo.getScore() == 0;
    private final BiPredicate<Player, Player> isEqualScore = (playerOne, playerTwo) -> playerOne.getScore() == playerTwo.getScore();
    private final BiPredicate<Player, Player> isPlayerWins = (playerOne, playerTwo) -> playerOne.getScore() > 3 && playerOne.getScore() >= playerTwo.getScore() + 2;

    public String getScore() {
        if (isLoveScore.test(playerOne, playerTwo)) {
            return getScoreLabel(0) + " - " + getScoreLabel(0);
        }

        if (isDeuceScore.test(playerOne, playerTwo)) {
            return "Deuce";
        }

        if (isEqualScore.test(playerOne, playerTwo)) {
            return getScoreLabel(playerOne.getScore()) + " - " + getScoreLabel(playerTwo.getScore());
        }

        if (isPlayerHasAdvantage.test(playerOne, playerTwo)) {
            return "Advantage " + playerOne.getName();
        }

        if (isPlayerHasAdvantage.test(playerTwo, playerOne)) {
            return "Advantage " + playerTwo.getName();
        }

        if (isPlayerWins.test(playerOne, playerTwo)) {
            return playerOne.getName() + " wins";
        }

        if (isPlayerWins.test(playerTwo, playerOne)) {
            return playerTwo.getName() + " wins";
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

