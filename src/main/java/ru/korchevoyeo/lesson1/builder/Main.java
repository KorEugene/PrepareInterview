package ru.korchevoyeo.lesson1.builder;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .middleName("Ivanovich")
                .country("Russia")
                .address("Some street")
                .phone("some phone")
                .age(999)
                .gender("M")
                .build();

        System.out.println(person);
    }
}
