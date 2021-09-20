package com.encora;

import java.util.LinkedList;
import java.util.List;

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
        return delete(root, value);
    }

    private Node delete(Node node, int value) {
        // Null validation
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getRight() == null && node.getLeft() == null) {
                // First scenario -> leaf
                return null;
            } else if (node.getLeft() == null) {
                // Second scenario -> one child
                return node.getRight();
            } else if (node.getRight() == null) {
                // Second scenario -> one child
                return node.getLeft();
            } else {
                // Third scenario -> two children
                int smallestRightNumber = smallestRightNumber(node.getRight());
                node.setValue(smallestRightNumber);
                node.setRight(delete(node.getRight(), smallestRightNumber));
            }
            return root;
        }

        return node;
    }

    private int smallestRightNumber(Node root) {
        /* Without recursion
        Node aux = root;
        while (aux.getLeft() != null) {
            aux = root.getLeft();
        }
        return aux.getValue();
         */
        Node left = root.getLeft();
        return left == null ? root.getValue() : smallestRightNumber(left);
    }

    public List<Integer> inOrder() {
        return inOrder(root);
    }

    private List<Integer> inOrder(Node node) {
        List<Integer> tree = new LinkedList<Integer>();
        if (node != null) {
            tree.addAll(inOrder(node.getLeft()));
            tree.add(node.getValue());
            tree.addAll(inOrder(node.getRight()));
        }
        return tree;
    }

    public List<Integer> preOrder() {
        return preOrder(root);
    }

    private List<Integer> preOrder(Node node) {
        List<Integer> tree = new LinkedList<Integer>();
        if (node != null) {
            tree.add(node.getValue());
            tree.addAll(inOrder(node.getLeft()));
            tree.addAll(inOrder(node.getRight()));
        }
        return tree;
    }

    public List<Integer> postOrder() {
        return postOrder(root);
    }

    private List<Integer> postOrder(Node node) {
        List<Integer> tree = new LinkedList<Integer>();
        if (node != null) {
            tree.addAll(inOrder(node.getLeft()));
            tree.addAll(inOrder(node.getRight()));
            tree.add(node.getValue());
        }
        return tree;
    }

    public int getRoot() {
        return root.getValue();
    }

    @Override
    public String toString() {
        if (root != null) {
            if (root.getLeft() != null) {
                if (root.getLeft().getLeft() != null) {
                    return toString();
                }
                System.out.println(root.getLeft().getValue());
            }
        }
        if (root != null) {
            System.out.println(root.getValue());
        }
        if (root.getRight() != null) {
            if (root.getRight().getRight() != null) {
                return toString();
            }
            System.out.println(root.getRight().getValue());
        }
        return "";
    }

}
