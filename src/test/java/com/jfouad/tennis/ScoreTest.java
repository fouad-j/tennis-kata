package com.jfouad.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreTest {

    @Test
    public void should_throw_exception_when_score_index_doesnt_exit() {
        Exception exception = assertThrows(RuntimeException.class, () -> Score.getScoreLabel(10));

        assertThat(exception.getMessage()).isEqualTo("Unknown index score");
    }
}
