package com.bgtutorial.hardemy;

import com.badlogic.gdx.graphics.g2d.Batch;

public class EnemyPlatform extends Platform {

    Ball ball;
    Scores scores;

    public EnemyPlatform(Ball ball, Scores scores)
    {
        this.ball = ball;
        this.scores = scores;
        setY(800-getHeight()); //задаємо позицію платформи в верхній частині екрану
        speed = 20; //задаємо швидкість платформи
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);

        setX(ball.getX()-getWidth()/2); //задаємо центрову позицію платформи, яка залежить від позиції м'яча

        if(ball.getBoundingRectangle().overlaps(getBoundingRectangle()))
        {
            ball.direction.y*=-1;
            scores.score++; //додаємо одне очко
        }
    }
}
