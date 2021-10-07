package com.encora.algorithm;

import com.encora.model.Node;

import java.util.List;

public interface Tree<T extends Comparable<T>> {

    Node<T> add(T data);
    boolean contains(T data);
    Node<T> delete(T data);
    List<T> display(Order order);
}
