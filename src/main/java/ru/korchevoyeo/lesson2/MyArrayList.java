package ru.korchevoyeo.lesson2;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 8;

    protected E[] data;
    protected int size;

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(E e) {
        checkAndGrow();
        data[size++] = e;
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
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);

        try {
            checkIndex(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        if (index == size - 1) {
            data[index] = null;
        } else {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
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
        Arrays.fill(data, null);
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        System.arraycopy(data, 0, objects, 0, size);
        return objects;
    }

    private void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String errorMsg = String.format("Incorrect 'index': %d; max value is %d",
                    index, size - 1);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }
}
