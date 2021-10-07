package com.encora.algorithm;

import com.encora.model.Node;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private Order order;

    @Override
    public Node<T> add(T data) {
        root = add(root, data);
        return root;
    }

    private Node<T> add(Node<T> node, T data) {
        if (node == null) {
            node = new Node<T>(data);
            return node;
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(add(node.getLeft(), data)); // We look for a lower node with recursion (left)
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(add(node.getRight(), data)); // We look for a greater node with recursion (right)
        }
        return node;
    }

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data) {
        if (node != null) {
            if (data.compareTo(node.getData()) < 0) {
                return contains(node.getLeft(), data); // We look for a lower node with recursion (left)
            } else if (data.compareTo(node.getData()) > 0) {
                return contains(node.getRight(), data); // We look for a greater node with recursion (right)
            } else {
                return true;
            }
        }
        return false;
    }

    public Node<T> delete(T data) {
        return delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        // Null validation
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(node.getRight(), data));
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
                T smallestRightNumber = smallestRightNumber(node.getRight());
                node.setData(smallestRightNumber);
                node.setRight(delete(node.getRight(), smallestRightNumber));
            }
            return root;
        }

        return node;
    }

    private T smallestRightNumber(Node<T> root) {
        /* Without recursion
        Node aux = root;
        while (aux.getLeft() != null) {
            aux = root.getLeft();
        }
        return aux.getValue();
         */
        Node<T> left = root.getLeft();
        return left == null ? root.getData() : smallestRightNumber(left);
    }


    private List<T> inOrder() {
        return inOrder(root);
    }

    private List<T> inOrder(Node<T> node) {
        List<T> tree = new LinkedList<>();
        if (node != null) {
            tree.addAll(inOrder(node.getLeft()));
            tree.add(node.getData());
            tree.addAll(inOrder(node.getRight()));
        }
        return tree;
    }

    private List<T> preOrder() {
        return preOrder(root);
    }

    private List<T> preOrder(Node<T> node) {
        List<T> tree = new LinkedList<>();
        if (node != null) {
            tree.add(node.getData());
            tree.addAll(inOrder(node.getLeft()));
            tree.addAll(inOrder(node.getRight()));
        }
        return tree;
    }

    private List<T> postOrder() {
        return postOrder(root);
    }

    private List<T> postOrder(Node<T> node) {
        List<T> tree = new LinkedList<>();
        if (node != null) {
            tree.addAll(inOrder(node.getLeft()));
            tree.addAll(inOrder(node.getRight()));
            tree.add(node.getData());
        }
        return tree;
    }

    public List<T> display(Order order) {
        this.order = order;
        switch (order) {
            case PREORDER:
                return preOrder();
            case POSTORDER:
                return postOrder();
            case INORDER:
            default:
                return inOrder();
        }
    }

    @Override
    public String toString() {
        return display(order).toString();
    }

    /*
    Effort difference between ArrayList vs LinkedList
    LinkedList -> easy to add/delete element
        Hard to search element by index
    ArrayList -> easy to search element by index
        Hard to add/delete element
     */

}
