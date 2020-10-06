package com.abenas.score.vo;

import java.util.List;

public class Highscore {

    private final List<Score> highscores;

    public Highscore(List<Score> scores) {
        this.highscores = scores;
    }

    public List<Score> getHighscores() {
        return highscores;
    }

}
