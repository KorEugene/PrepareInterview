package ru.korchevoyeo.lesson1.mistakes;

public class Lorry extends Car implements Movable, Stoppable { // было множественное наследование, хотя наследуем мы 1 класс и реализуем 2 интерфейса
    @Override
    void open() {
        System.out.println("Car is open"); // не был реализован абстрактный метод родителя
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}
