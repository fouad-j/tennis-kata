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
    void should_return_null() {
        tennisGame.playerOneScores();
        tennisGame.playerTwoScores();
        assertThat(tennisGame.getScore()).isNull();
    }
}
