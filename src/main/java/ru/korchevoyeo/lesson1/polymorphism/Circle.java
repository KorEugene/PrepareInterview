package ru.korchevoyeo.lesson1.polymorphism;

public class Circle extends Figure {
    @Override
    void rotate() {
        System.out.println("rotate circle");
    }

    @Override
    void draw() {
        System.out.println("draw circle");
    }
}
