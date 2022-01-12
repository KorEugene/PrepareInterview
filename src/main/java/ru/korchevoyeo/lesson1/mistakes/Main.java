package ru.korchevoyeo.lesson1.mistakes;

public class Main {
    public static void main(String[] args) {
        Lorry lorry = new Lorry();
        LightWeightCar lightWeightCar = new LightWeightCar();

        System.out.println("Lorry:");
        lorry.open();
        lorry.start();
        lorry.move();
        lorry.stop();

        System.out.println();

        System.out.println("LightWeightCar:");
        lightWeightCar.open();
        lightWeightCar.start();
        lightWeightCar.move();
    }
}
