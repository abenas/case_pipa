package com.abenas.score.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.abenas.score.component.HighscoreComponent;
import com.abenas.score.vo.Highscore;
import com.abenas.score.vo.Score;

public class ScoreServiceTest {

    private ScoreService scoreService;
    private HighscoreComponent highscoreComponent;
    private Highscore x;

    @BeforeEach
    public void setUp() {
        highscoreComponent = mock(HighscoreComponent.class);
        scoreService = new ScoreService(highscoreComponent);
    }

    @Test
    public void registerTest() {
        Score score = new Score(1, 100);
        scoreService.register(score);
        verify(highscoreComponent, times(1)).addScore(score);
    }

    @Test
    public void requestPositionTest() {
        int userId = 1;
        Score score = new Score(userId, 100);
        when(highscoreComponent.getUserPosition(userId)).thenReturn(score);
        assertEquals(score, scoreService.requestPosition(userId));
    }

    @Test
    public void requestHighScoreTest() {
        Highscore highscore = new Highscore(Arrays.asList(new Score(1, 100), new Score(2, 500)));
        when(highscoreComponent.getHighscore()).thenReturn(highscore);
        assertEquals(highscore, scoreService.requestHighScore());
    }
    
}
