package com.jfouad.tennis;

enum GameStatus {
    PLAYER_WIN("Player %s win"),
    ADVANTAGE("Advantage %s"),
    DEUCE("Deuce"),
    IN_PROGRESS("%s(%s) - %s(%s)");

    private final String text;

    GameStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
