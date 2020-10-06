package com.abenas.score.controller;

import com.abenas.score.service.ScoreService;
import com.abenas.score.vo.Highscore;
import com.abenas.score.vo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/score")
    public void registerScore(@RequestBody Score score) {
        scoreService.register(score);
    }

    @RequestMapping(value = "/{userId}/position", method = RequestMethod.GET)
    @ResponseBody
    public Score requestPosition(@PathVariable("userId") int userId) {
        return scoreService.requestPosition(userId);
    }

    @RequestMapping(value = "/highscorelist", method = RequestMethod.GET)
    public Highscore requestHighScore() {
        return scoreService.requestHighScore();
    }

}
