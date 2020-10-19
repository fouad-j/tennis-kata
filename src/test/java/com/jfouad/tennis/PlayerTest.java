package com.jfouad.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void should_test_equal_score(int nbrPointPlayer1, int nbrPointPlayer2, String expectedScore) {
        // GIVEN
        IntStream.rangeClosed(1, nbrPointPlayer1).forEach(a -> tennisGame.playerOneScores());
        IntStream.rangeClosed(1, nbrPointPlayer2).forEach(a -> tennisGame.playerTwoScores());

        // WHEN
        String resultScore = tennisGame.getScore();

        // THEN
        assertThat(resultScore).isEqualTo(expectedScore);
    }

    @Test
    void name() {

    }
}
