package com.encora;

import lombok.Data;
import lombok.NonNull;

@Data
class Node<T> {

    @NonNull
    private T data;
    private Node<T> left;
    private Node<T> right;

}
