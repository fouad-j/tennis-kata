package com.jfouad.tennis;

import com.jfouad.tennis.exceptions.UndefinedPlayerNameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    public void should_throw_exception_when_player_name_is_null() {
        Exception exception = assertThrows(UndefinedPlayerNameException.class, () -> new Player(null));

        assertThat(exception.getMessage()).isEqualTo("Player name couldn't be null");
    }

    @Test
    public void should_throw_exception_when_player_name_is_blank() {
        Exception exception = assertThrows(UndefinedPlayerNameException.class, () -> new Player(""));

        assertThat(exception.getMessage()).isEqualTo("Player name couldn't be null");
    }
}
