package com.abenas.score.vo;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score o1, Score o2) {
        return Integer.compare(o2.getPoints(), o1.getPoints());
    }
    
}
