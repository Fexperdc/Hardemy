package com.bgtutorial.hardemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Sprite { //успадковуємо клас Sprite

    public Vector2 direction = new Vector2(1, 1); //вектор напрямку м'яча
    public int speed; //швидкість м'яча

    public Ball()
    {
        super(new Texture(Gdx.files.internal("ball.png"))); //передаємо класу Sprite текстуру, яка знаходиться в папці assets
        setSize(32, 32); //розмір м'яча в пікселях
        setPosition((480/2)-getWidth()/2, (800/2)-getHeight()/2); //початкова позиція м'яча (в центрі екрана)
    }

    @Override
    public void draw(Batch batch) { //перевизначаємо метод draw
        super.draw(batch);

        if(getX()+getWidth()>480 || getX()<0) //умова якщо м'яч відбився від правої або лівої стінки
        {
            direction.x*=-1; //змінюємо вектор руху м'яча за рахунок множення його координати x на від'ємне число
        }

        if(getY()<0) //умова якщо м'яч вийшов за межі нижньої частини світу
            setPosition((480/2)-getWidth()/2, (800/2)-getHeight()/2); //ставимо м'яч назад по центру

        setPosition(getX()+ direction.x * speed, getY()+ direction.y * speed); //рух м'ча по вектору напрямку
    }
}
