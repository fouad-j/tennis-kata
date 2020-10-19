package com.jfouad.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private TennisGame tennisGame;

    @BeforeEach
    void setUp() {
        tennisGame = new TennisGame("Player A", "Player B");
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, LOVE - LOVE",
            "1, 1, 15 - 15",
            "2, 2, 30 - 30",
            "3, 3, Deuce",
    })
    void should_test_equal_score(int nbrPointsPlayer1, int nbrPointsPlayer2, String expectedScore) {
        // GIVEN
        IntStream.rangeClosed(1, nbrPointsPlayer1).forEach(a -> tennisGame.playerOneScores());
        IntStream.rangeClosed(1, nbrPointsPlayer2).forEach(a -> tennisGame.playerTwoScores());

        // WHEN
        String resultScore = tennisGame.getScore();

        // THEN
        assertThat(resultScore).isEqualTo(expectedScore);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 4, Advantage Player A",
            "4, 5, Advantage Player B",
    })
    void should_test_advantage_scenario(int nbrPointsPlayer1, int nbrPointsPlayer2, String expectedScore) {
        // GIVEN
        IntStream.rangeClosed(1, nbrPointsPlayer1).forEach(a -> tennisGame.playerOneScores());
        IntStream.rangeClosed(1, nbrPointsPlayer2).forEach(a -> tennisGame.playerTwoScores());

        // WHEN
        String resultScore = tennisGame.getScore();

        // THEN
        assertThat(resultScore).isEqualTo(expectedScore);
    }

    @ParameterizedTest
    @CsvSource({
            "4, 2, Player A wins",
            "1, 4, Player B wins",
            "4, 6, Player B wins",
            "4, 10, Player B wins",
    })
    void should_test_win_game_scenario(int nbrPointsPlayer1, int nbrPointsPlayer2, String expectedScore) {
        // GIVEN
        IntStream.rangeClosed(1, nbrPointsPlayer1).forEach(a -> tennisGame.playerOneScores());
        IntStream.rangeClosed(1, nbrPointsPlayer2).forEach(a -> tennisGame.playerTwoScores());

        // WHEN
        String resultScore = tennisGame.getScore();

        // THEN
        assertThat(resultScore).isEqualTo(expectedScore);
    }

}
