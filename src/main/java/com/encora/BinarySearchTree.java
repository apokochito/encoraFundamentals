package com.encora;

public class BinarySearchTree implements Tree {

    private Node root;


    public Node add(int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        } else if (value < root.getValue()) {
            // when root is already set.
            root = root.getLeft();
            add(value);
        } else if (value > root.getValue()) {
            root = root.getRight();
            add(value);
        }
        return null;
    }

    public boolean contains(int value) {
        if (root != null) {
            if (root.getValue() == value) {
                return true;
            } else if (value < root.getValue() ) {
                // verify if value is less or greater than node value
                root = root.getLeft(); // We look for a lower node (left)
                contains(value); // Recursion
            } else {
                return false;
            }
        }
        return false;
    }

    public Node delete(int value) {
        return null;
    }

}
