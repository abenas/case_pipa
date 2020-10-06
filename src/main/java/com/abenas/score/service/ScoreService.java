package com.abenas.score.service;

import com.abenas.score.component.HighscoreComponent;
import com.abenas.score.vo.Highscore;
import com.abenas.score.vo.Score;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final HighscoreComponent highscoreComponent;

    public ScoreService(HighscoreComponent highscoreComponent) {
        this.highscoreComponent = highscoreComponent;
    }

    public void register(Score score) {
        highscoreComponent.addScore(score);
    }

    public Score requestPosition(int userId) {
        return highscoreComponent.getUserPosition(userId);
    }

    public Highscore requestHighScore() {
        return highscoreComponent.getHighscore();
    }

}
