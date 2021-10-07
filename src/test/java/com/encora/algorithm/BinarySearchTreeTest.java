package com.encora.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinarySearchTreeTest {

    private Tree<Integer> tree;

    @BeforeEach
    void init() {
        this.tree = new BinarySearchTree<>();
    }

    @Test
    void add() {
        assertThat(tree.contains(1)).isFalse();
        assertThat(tree.add(1)).isNotNull();
        assertThat(tree.contains(1)).isTrue();
    }

    @Test
    void contains() {
        assertThat(tree.contains(25)).isFalse();
        assertThat(tree.add(18)).isNotNull();
        assertThat(tree.contains(18)).isTrue();
        assertThat(tree.add(25)).isNotNull();
        assertThat(tree.contains(25)).isTrue();
        assertThat(tree.contains(18)).isTrue();
        assertThat(tree.contains(1)).isFalse();
    }

    @Test
    void deleteLeaf() {
        assertThat(tree.add(5)).isNotNull();
        assertThat(tree.add(3)).isNotNull();
        assertThat(tree.add(6)).isNotNull();
        assertThat(tree.add(7)).isNotNull();
        assertThat(tree.add(1)).isNotNull();
        assertThat(tree.contains(1)).isTrue();
        assertThat(tree.contains(7)).isTrue();
        assertThat(tree.delete(1)).isNotNull();
        assertThat(tree.contains(1)).isFalse();
        assertThat(tree.delete(7)).isNotNull();
        assertThat(tree.contains(7)).isFalse();
    }

    @Test
    void deleteOneChild() {
        assertThat(tree.add(5)).isNotNull();
        assertThat(tree.add(3)).isNotNull();
        assertThat(tree.add(6)).isNotNull();
        assertThat(tree.add(7)).isNotNull();
        assertThat(tree.add(1)).isNotNull();
        assertThat(tree.contains(3)).isTrue();
        assertThat(tree.contains(6)).isTrue();
        assertThat(tree.delete(3)).isNotNull();
        assertThat(tree.contains(3)).isFalse();
        assertThat(tree.delete(6)).isNotNull();
        assertThat(tree.contains(6)).isFalse();
    }

    @Test
    void deleteTwoChildren() {
        assertThat(tree.add(5)).isNotNull();
        assertThat(tree.add(3)).isNotNull();
        assertThat(tree.add(6)).isNotNull();
        assertThat(tree.add(7)).isNotNull();
        assertThat(tree.add(1)).isNotNull();
        assertThat(tree.contains(5)).isTrue();
        assertThat(tree.delete(5)).isNotNull();
        assertThat(tree.contains(5)).isFalse();
        assertThat(tree.contains(3)).isTrue();
    }

    @Test
    void inOrder() {
        assertThat(tree.add(5)).isNotNull();
        assertThat(tree.add(3)).isNotNull();
        assertThat(tree.add(6)).isNotNull();
        assertThat(tree.add(7)).isNotNull();
        assertThat(tree.add(1)).isNotNull();
        assertThat(tree.contains(5)).isTrue();
        assertThat(tree.display(Order.INORDER)).containsExactly(1, 3, 5, 6, 7);
        assertThat(tree.toString()).isNotBlank().isEqualTo("[1, 3, 5, 6, 7]");
    }

    @Test
    void preOrder() {
        assertThat(tree.add(5)).isNotNull();
        assertThat(tree.add(3)).isNotNull();
        assertThat(tree.add(6)).isNotNull();
        assertThat(tree.add(7)).isNotNull();
        assertThat(tree.add(1)).isNotNull();
        assertThat(tree.contains(5)).isTrue();
        assertThat(tree.display(Order.PREORDER)).containsExactly(5, 1, 3, 6, 7);
        assertThat(tree.toString()).isNotBlank().isEqualTo("[5, 1, 3, 6, 7]");
    }

    @Test
    void postOrder() {
        assertThat(tree.add(5)).isNotNull();
        assertThat(tree.add(3)).isNotNull();
        assertThat(tree.add(6)).isNotNull();
        assertThat(tree.add(7)).isNotNull();
        assertThat(tree.add(1)).isNotNull();
        assertThat(tree.contains(5)).isTrue();
        assertThat(tree.display(Order.POSTORDER)).containsExactly(1, 3, 6, 7, 5);
        assertThat(tree.toString()).isNotBlank().isEqualTo("[1, 3, 6, 7, 5]");
    }

}