package com.abenas.score.service;

import com.abenas.score.component.HighscoreComponent;
import com.abenas.score.vo.Highscore;
import com.abenas.score.vo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private HighscoreComponent highscoreComponent;

    public void register(Score score) {
        highscoreComponent.addScore(score);
    }

    public Score requestPosition(int userId) {
        return highscoreComponent.getUserPosition(userId);
    }

    public Highscore requestHighScore() {
        final List<Score> scores = highscoreComponent.getScores();
        Highscore highscore = new Highscore();
        highscore.setHighscores(scores);
        return highscore;
    }
}
