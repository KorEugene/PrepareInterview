package ru.korchevoyeo.lesson2;

import java.util.Collection;

public class MyLinkedList<E> implements MyList<E> {
    private int size;
    private Node<E> firstElement;
    private Node<E> lastElement;

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e, null);
        insertLastNode(newNode);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] objects = c.toArray();
        int additionalLength = objects.length;
        if (additionalLength == 0) {
            return false;
        }
        for (Object object : objects) {
            add((E) object);
        }
        return true;
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(o)) {
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        int counter = 0;
        Node<E> current = firstElement;

        if (counter == index) {
            return current.item;
        }

        while (counter != index) {
            current = current.next;
            counter++;
        }

        return current.item;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(o)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        int additionalLength = objects.length;
        if (additionalLength == 0) {
            return false;
        }
        for (Object object : objects) {
            remove(object);
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] objects = c.toArray();
        int additionalLength = objects.length;
        if (additionalLength == 0) {
            return false;
        }
        for (Object object : objects) {
            contains(object);
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        firstElement = null;
        lastElement = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        int counter = 0;
        Node<E> current = firstElement;
        while (current != null) {
            objects[counter] = current.item;
            current = current.next;
            counter++;
        }
        return objects;
    }

    private void insertLastNode(Node<E> newNode) {
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    private void removeFirst() {
        if (isEmpty()) {
            return;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;

        size--;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        public Node(E item, Node<E> next) {
            this(item, next, null);
        }

        public Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
}
