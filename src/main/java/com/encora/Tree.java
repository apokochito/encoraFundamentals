package com.encora;

import java.util.List;

public interface Tree {

    Node add(int value);
    boolean contains(int value);
    Node delete(int value);
    List<Integer> inOrder();
    List<Integer> preOrder();
    List<Integer> postOrder();
    int getRoot();
    Order getOrder();
    void setOrder(Order order);
}
