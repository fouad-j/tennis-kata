package com.jfouad.tennis;

public enum Score {
    ZERO("LOVE"), FIFTEEN("15"), THIRTY("30"), FORTY("40");

    private String scoreValue;

    Score(String scoreValue) {
        this.scoreValue = scoreValue;
    }

    public static String getScoreLabel(int scoreValue) {
        try {
            return Score.values()[scoreValue].scoreValue;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Unknown index score");
        }
    }
}
