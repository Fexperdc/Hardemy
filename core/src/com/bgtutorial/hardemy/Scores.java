package com.bgtutorial.hardemy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Scores extends BitmapFont {

    public int score = 0; //змінна очків

    public Scores()
    {
        setColor(Color.BLACK); //задаємо колір тексту, в нашому випадку чорний
    }

    public void draw(Batch batch) //творюємо власний метод з аргументом Batch
    {
        draw(batch, ""+score, 240, 400); //відмальовуємо текст з координатами по центру екрана
    }

}
