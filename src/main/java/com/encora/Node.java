package com.encora;

import lombok.Data;
import lombok.NonNull;

@Data
class Node {

    @NonNull
    private int value;
    private Node left;
    private Node right;

}
