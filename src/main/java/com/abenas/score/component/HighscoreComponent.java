package com.abenas.score.component;


import com.abenas.score.vo.Highscore;
import com.abenas.score.vo.Score;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HighscoreComponent {

    private final List<Score> scores;

    public HighscoreComponent() {
        scores = new ArrayList<>();
    }

    private List<Score> getScores() {
        sort();
        return scores;
    }

    private void sort() {
        scores.sort(Score::compareTo);
        scores.parallelStream().forEach(it -> {it.setPosition(scores.indexOf(it) + 1);});
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
        final Optional<Score> first = scores.stream().filter(it -> it.getUserId() == userId).findFirst();
        return first.orElse(null);
    }

    public Highscore getHighscore() {
        return new Highscore(this.getScores());
    }

}
