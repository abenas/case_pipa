package com.abenas.score.vo;

import java.util.Objects;

public class Score {

    private int userId;
    private int points;
    private int position;

    public Score() {
    }

    public int getUserId() {
        return userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return userId == score.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

}
