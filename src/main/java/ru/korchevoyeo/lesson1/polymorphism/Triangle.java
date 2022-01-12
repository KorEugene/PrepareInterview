package ru.korchevoyeo.lesson1.polymorphism;

public class Triangle extends Figure {
    @Override
    void rotate() {
        System.out.println("rotate triangle");
    }

    @Override
    void draw() {
        System.out.println("draw triangle");
    }
}
