package com.abenas.score.component;


import com.abenas.score.vo.Score;
import com.abenas.score.vo.ScoreComparator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class HighscoreComponent {

    private List<Score> scores = new ArrayList<>();

    public HighscoreComponent() {
        scores = new ArrayList<Score>();
    }

    public List<Score> getScores() {
        sort();
        return scores;
    }

    public void sort() {
        ScoreComparator scoreComparator = new ScoreComparator();
        scores.sort(scoreComparator);
        scores.forEach(it -> {
            it.setPosition(scores.indexOf(it) + 1);
        });
    }

    public void addScore(Score score) {

        if (scores.contains(score)) {
            scores.get(scores.indexOf(score)).setPoints(score.getPoints());
        } else {
            scores.add(score);
        }
        sort();

    }

    public Score getUserPosition(int userId) {
        if (!(scores.size() == 0)) {
            return scores.stream().filter(it -> {
                return it.getUserId() == userId;
            }).findFirst().get();
        }
        return null;
    }
}
