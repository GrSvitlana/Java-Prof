package com.telran.lecture.Okt17_MyLinkedList;

import lombok.Getter;
import java.util.Iterator;

@Getter
public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void pushToHead(T data) {
        Node<T> h = head;
        Node<T> newNode = new Node<T>(null, h, data);
        head = newNode;
        if (h == null) {
            tail = newNode;
        } else {
            h.setPrevious(head);
        }
        size++;
    }

    public void pushToTail(T data) {
        Node<T> t = tail;
        Node<T> newNode = new Node<T>(t, null, data);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.setNext(tail);
        }
        size++;
    }

    public void pushToIndex(int index, T data) {
        int last = index - 1;
        Node<T> currentNode = head;
        for (int i = 0; i < last; i++) {
            currentNode = currentNode.getNext();
        }
        Node<T> newNode = new Node<T>(currentNode, currentNode.getNext(), data);
        currentNode.getNext().setPrevious(newNode);
        currentNode.setNext(newNode);
        size++;
    }

    public void removeFirst() {
        head = head.getNext();
        size--;
    }

    public Object removeLast() {
        Node<T> h = head;
        while (true) {
            Node<T> newNode = h.getNext();
            if (newNode.getNext() == null) {
                h.setNext(null);
                return newNode.getData();
            } else {
                h = newNode;
            }
            size--;
        }
    }

    public void removeByIndex(int index) {
        Node<T> newNode = head;
        for (int i = 0; i <= index; i++) {
            newNode = newNode.getNext();
        }
        newNode.getPrevious().setNext(newNode.getNext());
        newNode.getNext().setPrevious(newNode.getPrevious());
        size--;
    }

    public T getByIndex(int index) {
        int count = -1;
        Node<T> newNode = head;
        while (newNode != null) {
            count++;
            if (count == index) {
                return (T) newNode.getData();
            }
            newNode = newNode.getNext();
        }
        return null;
    }

    public int size() {
        int size = 0;
        Node<T> newNode = head;
        while (newNode != null) {
            newNode = newNode.getNext();
            size++;
        }
        return size;
    }

    public void print() {
        Node<T> newNode = head;
        while (newNode != null) {
            System.out.println(newNode.getData());
            newNode = newNode.getNext();
        }
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator(this);
    }
}
