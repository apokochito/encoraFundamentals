package com.encora;

public class BinarySearchTree implements Tree {

    private Node root;

    public Node add(int value) {
        root = add(root, value);
        return root;
    }

    private Node add(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        } else if (value < node.getValue()) {
            node.setLeft(add(node.getLeft(), value)); // We look for a lower node with recursion (left)
        } else if (value > node.getValue()) {
            node.setRight(add(node.getRight(), value)); // We look for a greater node with recursion (right)
        }
        return node;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node != null) {
            if (value < node.getValue()) {
                return contains(node.getLeft(), value); // We look for a lower node with recursion (left)
            } else if (value > node.getValue()) {
                return contains(node.getRight(), value); // We look for a greater node with recursion (right)
            } else {
                return true;
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
