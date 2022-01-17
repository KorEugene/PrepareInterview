package ru.korchevoyeo.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MyArrayList
        System.out.println();
        MyList<Integer> myArrayList = new MyArrayList<>();
        System.out.println("MY ARRAY LIST:");

        System.out.println("add one element:");
        myArrayList.add(1);
        System.out.println(Arrays.asList(myArrayList.toArray()));

        List<Integer> addList = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        System.out.println("add collection of elements:");
        myArrayList.addAll(addList);
        System.out.println(Arrays.asList(myArrayList.toArray()));

        System.out.println("index of element=3: " + myArrayList.indexOf(3));

        System.out.println("get element with index=2 from my array list: " + myArrayList.get(2));

        System.out.println("remove from my array list element=1:");
        myArrayList.remove(1);
        System.out.println(Arrays.asList(myArrayList.toArray()));

        List<Integer> deleteList = new ArrayList<>(Arrays.asList(2, 3));
        System.out.println("remove collection of elements from my array list:");
        myArrayList.removeAll(deleteList);
        System.out.println(Arrays.asList(myArrayList.toArray()));

        List<Integer> emptyList = Collections.emptyList();
        System.out.println("can be removed empty collection from my array list?: " + myArrayList.removeAll(emptyList));

        System.out.println("my array list contains element=5?: " + myArrayList.contains(5));

        List<Integer> containsList = new ArrayList<>(Arrays.asList(4, 5));
        System.out.println("my array list contains elements 4 and 5?: " + myArrayList.containsAll(containsList));

        System.out.println("my array list size=" + myArrayList.size());

        System.out.println("clear my array list!");
        myArrayList.clear();

        System.out.println("is my array list empty?: " + myArrayList.isEmpty());

//        MyLinkedList
        System.out.println();
        MyList<Integer> myLinkedList = new MyLinkedList<>();
        System.out.println("MY LINKED LIST:");

        System.out.println("add one element:");
        myLinkedList.add(1);
        System.out.println(Arrays.asList(myLinkedList.toArray()));

        List<Integer> addList2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        System.out.println("add collection of elements:");
        myLinkedList.addAll(addList2);
        System.out.println(Arrays.asList(myLinkedList.toArray()));

        System.out.println("index of element=3: " + myLinkedList.indexOf(3));

        System.out.println("get element with index=2 from my linked list: " + myLinkedList.get(2));

        System.out.println("remove from my linked list element=1:");
        myLinkedList.remove(1);
        System.out.println(Arrays.asList(myLinkedList.toArray()));

        List<Integer> deleteList2 = new ArrayList<>(Arrays.asList(2, 3));
        System.out.println("remove collection of elements from my linked list:");
        myLinkedList.removeAll(deleteList2);
        System.out.println(Arrays.asList(myLinkedList.toArray()));

        List<Integer> emptyList2 = Collections.emptyList();
        System.out.println("can be removed empty collection from my linked list?: " + myLinkedList.removeAll(emptyList2));

        System.out.println("my linked list contains element=5?: " + myLinkedList.contains(5));

        List<Integer> containsList2 = new ArrayList<>(Arrays.asList(4, 5));
        System.out.println("my linked list contains elements 4 and 5?: " + myLinkedList.containsAll(containsList2));

        System.out.println("my linked list size=" + myLinkedList.size());

        System.out.println("clear my linked list!");
        myLinkedList.clear();

        System.out.println("is my linked list empty?: " + myLinkedList.isEmpty());
    }
}
