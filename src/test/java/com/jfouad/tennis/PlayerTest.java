package com.jfouad.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private TennisGame tennisGame;

    @BeforeEach
    void setUp() {
        tennisGame = new TennisGame("Player A", "Player B");
    }

    @Test
    void should_return_love_for_player_one_and_two_as_initial_value() {
        assertThat(tennisGame.getScore()).isEqualTo("LOVE - LOVE");
    }

    @Test
    void should_return_30_when_each_player_has_1_point() {
        tennisGame.playerOneScores();
        tennisGame.playerTwoScores();
        assertThat(tennisGame.getScore()).isEqualTo("15 - 15");
    }

    @Test
    void should_return_30_when_each_player_has_2_points() {
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        assertThat(tennisGame.getScore()).isEqualTo("30 - 30");
    }

    @Test
    void should_return_deuce_when_score_is_40_for_both() {
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        assertThat(tennisGame.getScore()).isEqualTo("Deuce");
    }
}
