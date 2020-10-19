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

    @ParameterizedTest(name = "should return {2} when player one has {0} point(s) and player two has {1} point(s)")
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
            "8, 10, Player B wins",
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

    @ParameterizedTest(name = "should return {2} when player one has {0} and player two has {1}")
    @CsvSource({
            "0, 1, LOVE - 15",
            "0, 2, LOVE - 30",
            "0, 3, LOVE - 40",
            "1, 0, 15 - LOVE",
            "1, 2, 15 - 30",
            "1, 3, 15 - 40",
            "2, 0, 30 - LOVE",
            "2, 1, 30 - 15",
            "2, 3, 30 - 40",
    })
    void should_test_(int nbrPointsPlayer1, int nbrPointsPlayer2, String expectedScore) {
        // GIVEN
        IntStream.rangeClosed(1, nbrPointsPlayer1).forEach(a -> tennisGame.playerOneScores());
        IntStream.rangeClosed(1, nbrPointsPlayer2).forEach(a -> tennisGame.playerTwoScores());

        // WHEN
        String resultScore = tennisGame.getScore();

        // THEN
        assertThat(resultScore).isEqualTo(expectedScore);

    }
}
