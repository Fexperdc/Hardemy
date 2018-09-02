package com.bgtutorial.hardemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Platform extends Sprite { //успадковуємо клас Sprite
    
    public int speed, boundLeft = 0, boundRight = 480; //швидкість платформи, обмеження руху платформи зліва та справа по стандарту
    public Vector2 center = new Vector2(); //центр платформи

    public Platform()
    {
        super(new Texture(Gdx.files.internal("platform.png"))); //передаємо класу Sprite текстуру, яка знаходиться в папці assets
        setSize(128, 32); //задаємо розмір платформи (спрайту)
    }

    public void moveLeft() //метод руху платформи вліво
    {
        if(getX()>boundLeft)
        setX(getX()-speed);
    }

    public void moveRight() //метод руху платформи вправо
    {
        if(getX()+getWidth()<boundRight)
        setX(getX()+speed);
    }

    @Override
    public void draw(Batch batch) { //перевизначаємо метод draw
        super.draw(batch);

        center.set(getX()+getWidth()/2, getY()+getHeight()/2); //записуємо координтаи центру платформи в контейнер (вектор)
    }
}
