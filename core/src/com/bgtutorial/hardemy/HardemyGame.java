package com.bgtutorial.hardemy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class HardemyGame extends ApplicationAdapter {

    OrthographicCamera camera;
    FitViewport viewport;
    SpriteBatch batch;
    Sprite background;

    Ball ball;
    PlayerPlatform playerPlatform;
    EnemyPlatform enemyPlatform;
    Scores scores;

    @Override
    public void create() { //викликається при запуску програми
        super.create();

        camera = new OrthographicCamera(480, 800); //камера
        viewport = new FitViewport(480, 800, camera); //вікно перегляду
        batch = new SpriteBatch();
        background = new Sprite(new Texture(Gdx.files.internal("background.png"))); //спрайт нашого фону
        scores = new Scores();
        ball = new Ball();
        playerPlatform = new PlayerPlatform(ball);
        enemyPlatform = new EnemyPlatform(ball, scores);


        background.setSize(480, 800); //задаємо розмір фона в пікселях, під розмір нашого ігрового світу

        playerPlatform.speed = 10; //задаємо швидкість гравця
        ball.speed = 10; //задаємо швидкість м'яча

        camera.position.set(240, 400, 0); //задаємо позицію камери в світі по центрі
        camera.update(); //обновлення камери
    }

    @Override
    public void render() { //викликається 60 раз в секунду
        super.render();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //очистка екрана

        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin(); //початок малювання
        background.draw(batch); //малюємо фон
        playerPlatform.draw(batch); //малюємо гравця
        ball.draw(batch); //малюємо м'яч
        enemyPlatform.draw(batch); //малюємо противника
        scores.draw(batch); //малюємо очки
        batch.end(); //кінець малювання
    }
}
