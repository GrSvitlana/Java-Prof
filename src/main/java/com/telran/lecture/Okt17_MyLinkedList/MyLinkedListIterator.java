package com.telran.lecture.Okt17_MyLinkedList;

import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T> {
    Node<T> current;
    public MyLinkedListIterator (MyLinkedList list) {
        current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}
