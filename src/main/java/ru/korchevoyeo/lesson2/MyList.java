package ru.korchevoyeo.lesson2;

import java.util.Collection;

public interface MyList<E> {

    boolean add(E e);

    boolean addAll(Collection<? extends E> c);

    int indexOf(Object o);

    E get(int index);

    boolean remove(Object o);

    boolean removeAll(Collection<?> c);

    boolean contains(Object o);

    boolean containsAll(Collection<?> c);

    int size();

    boolean isEmpty();

    void clear();

    Object[] toArray();
}
