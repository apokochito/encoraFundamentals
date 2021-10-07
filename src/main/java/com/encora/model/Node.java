package com.encora.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node<T> {

    @NonNull
    private T data;
    private Node<T> left;
    private Node<T> right;

}
