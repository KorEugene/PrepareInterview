package ru.korchevoyeo.lesson1.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>(Arrays.asList(new Circle(), new Triangle(), new Square()));

        for (Figure figure : figures) {
            figure.draw();
            figure.rotate();
        }
    }
}
