package com.encora;

public class BinarySearchTree implements Tree {

    private Node root;

    public Node add(int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        } else if (value < root.getValue()) {
            // when root is already set.
            if (root.getLeft() == null) { // We look for a lower node (left)
                root.setLeft(new Node(value));
                return root; // Recursion
            } else {
                add(value); // is there need to reassign root?
            }
        } else if (value > root.getValue()) {
            if (root.getRight() == null) { // We look for a grader node (right)
                root.setRight(new Node(value));
                return root;
            } else {
                add(value); // is there need to reassign root?
            }
        }
        return null;
    }

    public boolean contains(int value) {
        if (root != null) {
            if (root.getValue() == value) {
                return true;
            } else if (value < root.getValue()) {
                // verify if value is less or greater than node value
                if (root.getLeft() != null) {
                    root = root.getLeft(); // is there need to reassign root?
                    return contains(value);
                }
            } else if (value > root.getValue()) {
                if (root.getRight() != null) {
                    root = root.getRight(); // is there need to reassign root?
                    return contains(value);
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public Node delete(int value) {
        return null;
    }

    public String printInOrder() {
        if (root != null) {
            if (root.getLeft().getLeft() != null) {
                printInOrder();
            }
            System.out.println(root.getLeft().getValue());
        }
        if (root != null) {
            System.out.println(root.getValue());
        }
        if (root.getRight().getRight() != null) {
            printInOrder();
        }
        System.out.println(root.getRight().getValue());
        return "";
    }

}
