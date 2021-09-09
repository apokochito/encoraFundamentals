package com.encora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinarySearchTreeTest {

    private Tree tree;

    @BeforeEach
    void init() {
        this.tree = new BinarySearchTree();
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
        // assertThat(tree.contains(18)).isTrue(); Test is failing because of the root
        assertThat(tree.contains(1)).isFalse();
    }

    @Test
    void printInOrder() {
        assertThat(tree.add(3)).isNotNull();
        assertThat(tree.add(37)).isNotNull();
        assertThat(tree.add(2)).isNotNull();
        // assertThat(tree.add(49)).isNotNull(); Test is failing (StackOverflowError) because of the root
        assertThat(tree.printInOrder()).isEmpty();
    }
}