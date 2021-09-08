package com.encora;

import org.junit.jupiter.api.BeforeAll;
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
        assertThat(tree.add(1)).isNull();
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
}