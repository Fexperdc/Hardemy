package com.bgtutorial.hardemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;

public class PlayerPlatform extends Platform { //успадковуємо клас Platform

    Ball ball;

    public PlayerPlatform(Ball ball)
    {
        this.ball = ball;
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerX()>0) //умова якщо неатиснута клавіша ВЛІВО або смартфон повернутий ВЛІВО
        {
            moveLeft(); //рух платформи вліво
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerX()<0) //умова якщо неатиснута клавіша ВПРАВО або смартфон повернутий ВПРАВО
        {
            moveRight(); //рух платформи вправо
        }

        if(ball.getBoundingRectangle().overlaps(getBoundingRectangle())) //умова якщо м'яч належить платформі
        {
            ball.direction.y*=-1;
        }
    }
}
