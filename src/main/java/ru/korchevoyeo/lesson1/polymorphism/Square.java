package ru.korchevoyeo.lesson1.polymorphism;

public class Square extends Figure {
    @Override
    void rotate() {
        System.out.println("rotate square");
    }

    @Override
    void draw() {
        System.out.println("draw square");
    }
}
