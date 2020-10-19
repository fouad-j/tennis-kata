package com.jfouad.tennis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import static com.jfouad.tennis.Score.getScoreLabel;

public class TennisGame {
    private final BiPredicate<Player, Player> isDeuceScore = (playerOne, playerTwo) -> playerOne.getScore() >= 3 && playerOne.getScore() == playerTwo.getScore();
    private final BiPredicate<Player, Player> isEqualScore = (playerOne, playerTwo) -> playerOne.getScore() == playerTwo.getScore();
    private final BiPredicate<Player, Player> isPlayerWins = (playerOne, playerTwo) ->
            (playerOne.getScore() > 3 && playerOne.getScore() >= playerTwo.getScore() + 2) ||
            (playerTwo.getScore() > 3 && playerTwo.getScore() >= playerOne.getScore() + 2);
    private final BiPredicate<Player, Player> isPlayerHasAdvantage = (playerOne, playerTwo) ->
            (playerOne.getScore() > 3 && playerOne.getScore() == playerTwo.getScore() + 1) ||
            (playerTwo.getScore() > 3 && playerTwo.getScore() == playerOne.getScore() + 1);

    private final Map<BiPredicate<Player, Player>, BiFunction<Player, Player, String>> rules =
            new LinkedHashMap<BiPredicate<Player, Player>, BiFunction<Player, Player, String>>() {{
                put(isDeuceScore, (playerOne, playerTwo) -> "Deuce");
                put(isEqualScore, (playerOne, playerTwo) -> getScoreLabel(playerOne.getScore()) + " - " + getScoreLabel(playerTwo.getScore()));
                put(isPlayerHasAdvantage, (playerOne, playerTwo) -> "Advantage " + getLeadGameName(playerOne, playerTwo));
                put(isPlayerWins, (playerOne, playerTwo) -> getLeadGameName(playerOne, playerTwo) + " wins");
            }};

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(String namePlayerOne, String namePlayerTwo) {
        this.playerOne = new Player(namePlayerOne, 0);
        this.playerTwo = new Player(namePlayerTwo, 0);
    }

    public String getScore() {
        return rules.entrySet().stream()
                .filter(e -> e.getKey().test(playerOne, playerTwo))
                .map(Map.Entry::getValue)
                .findFirst()
                .map(e -> e.apply(playerOne, playerTwo))
                .orElseThrow(() -> new RuntimeException("Unknown scenario")); // TODO create custom Exception
    }

    public void playerOneScores() {
        this.playerOne.scores();
    }

    public void playerTwoScores() {
        this.playerTwo.scores();
    }

    private String getLeadGameName(Player playerOne, Player playerTwo) {
        return playerOne.getScore() > playerTwo.getScore()
                ? playerOne.getName()
                : playerTwo.getName();
    }

}

