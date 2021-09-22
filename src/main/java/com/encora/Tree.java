package com.encora;

import java.util.List;

public interface Tree<T> extends Comparable<T> {

    Node<T> add(T data);
    boolean contains(T data);
    Node<T> delete(T data);
    List<T> inOrder();
    List<T> preOrder();
    List<T> postOrder();
    T getRoot();
    void setOrder(Order order);
}
