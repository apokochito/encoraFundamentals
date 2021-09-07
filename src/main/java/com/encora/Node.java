package com.encora;

import lombok.Data;

@Data
class Node {

    private final int value;
    private Node left;
    private Node right;

}
