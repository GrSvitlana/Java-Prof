package com.telran.lecture.Okt17_MyLinkedList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T data;

    public Node(Node<T> previous, Node<T> next, T data) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }
}
