package com.jfouad.tennis;

import com.jfouad.tennis.exceptions.UnknownTennisRuleException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import static com.jfouad.tennis.Score.getScoreLabel;

public class TennisGame {
    private final BiPredicate<Player, Player> isDeuceScore = (playerOne, playerTwo) -> playerOne.getScore() >= 3 && playerOne.getScore() == playerTwo.getScore();
    private final BiPredicate<Player, Player> isPlayerWins = (playerOne, playerTwo) ->
            (playerOne.getScore() > 3 && playerOne.getScore() >= playerTwo.getScore() + 2) ||
            (playerTwo.getScore() > 3 && playerTwo.getScore() >= playerOne.getScore() + 2);
    private final BiPredicate<Player, Player> isPlayerHasAdvantage = (playerOne, playerTwo) ->
            (playerOne.getScore() > 3 && playerOne.getScore() == playerTwo.getScore() + 1) ||
            (playerTwo.getScore() > 3 && playerTwo.getScore() == playerOne.getScore() + 1);
    private final BiPredicate<Player, Player> isGameInProgress = (playerOne, playerTwo) -> playerOne.getScore() <= 3 && playerTwo.getScore() <= 3;

    private final Map<BiPredicate<Player, Player>, BiFunction<Player, Player, String>> rules = new LinkedHashMap<>() {{
        put(isDeuceScore, (playerOne, playerTwo) -> "Deuce");
        put(isPlayerHasAdvantage, (playerOne, playerTwo) -> "Advantage " + getLeadGameName(playerOne, playerTwo));
        put(isPlayerWins, (playerOne, playerTwo) -> getLeadGameName(playerOne, playerTwo) + " wins");
        put(isGameInProgress, (playerOne, playerTwo) -> getScoreLabel(playerOne.getScore()) + " - " + getScoreLabel(playerTwo.getScore()));
    }};

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(String namePlayerOne, String namePlayerTwo) {
        this.playerOne = new Player(namePlayerOne);
        this.playerTwo = new Player(namePlayerTwo);
    }

    public String getScore() {
        return rules.entrySet()
                .stream()
                .filter(rule -> rule.getKey().test(playerOne, playerTwo))
                .map(Map.Entry::getValue)
                .findFirst()
                .map(renderAppliedRule -> renderAppliedRule.apply(playerOne, playerTwo))
                .orElseThrow(() -> new UnknownTennisRuleException("Unknown tennis rule"));
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

