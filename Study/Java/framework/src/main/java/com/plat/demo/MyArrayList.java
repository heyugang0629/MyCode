package com.plat.demo;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by jack on 2021/3/20.
 */
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10 ;

    private int theSize;

    private T[] theItems;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
