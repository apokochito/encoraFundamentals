package com.encora;

import com.encora.algorithm.BinarySearchTree;
import com.encora.algorithm.Order;
import com.encora.algorithm.Tree;
import com.encora.model.Wine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WineBinarySearchTreeTest {

    private Tree<Wine> tree;
    private Wine myFirstWine;
    private Wine mySecondWine;
    private Wine myThirdWine;
    private Wine myFourthWine;
    private Wine myFifthWine;
    private Wine mySixthWine;

    @BeforeEach
    void init() {
        this.tree = new BinarySearchTree<>();
        this.myFirstWine = new Wine("Adobe Guadalupe","red",3.51,0.56,5);
        this.mySecondWine = new Wine("St Thomas","red",3.26,0.54,7);
        this.myThirdWine = new Wine("Shiraz","red",3.3,0.57,6);
        this.myFourthWine = new Wine("Albarolo","red",3.28,0.46,5);
        this.myFifthWine = new Wine("Chardonnay","white",3.22,9.5,6);
        this.mySixthWine = new Wine("La Cetto","white",3.20,5.8,4);
    }

    @Test
    void add() {
        assertThat(tree.contains(myFirstWine)).isFalse();
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.contains(myFirstWine)).isTrue();
    }

   @Test
    void contains() {
        assertThat(tree.contains(myFirstWine)).isFalse();
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.contains(myFirstWine)).isTrue();
        assertThat(tree.add(mySecondWine)).isNotNull();
        assertThat(tree.contains(mySecondWine)).isTrue();
        assertThat(tree.contains(myFirstWine)).isTrue();
        assertThat(tree.contains(new Wine("Barón Balché","red",3.35,0.8,5))).isFalse();
    }

    @Test
    void deleteLeaf() {
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.add(mySecondWine)).isNotNull();
        assertThat(tree.add(myThirdWine)).isNotNull();
        assertThat(tree.add(myFourthWine)).isNotNull();
        assertThat(tree.add(myFifthWine)).isNotNull();
        assertThat(tree.contains(myThirdWine)).isTrue();
        assertThat(tree.contains(myFirstWine)).isTrue();
        assertThat(tree.delete(myFifthWine)).isNotNull();
        assertThat(tree.contains(myFifthWine)).isFalse();
        assertThat(tree.delete(mySecondWine)).isNotNull();
        assertThat(tree.contains(mySecondWine)).isFalse();
    }


    @Test
    void deleteOneChild() {
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.add(mySecondWine)).isNotNull();
        assertThat(tree.add(myThirdWine)).isNotNull();
        assertThat(tree.add(myFourthWine)).isNotNull();
        assertThat(tree.add(myFifthWine)).isNotNull();
        assertThat(tree.contains(myThirdWine)).isTrue();
        assertThat(tree.contains(mySecondWine)).isTrue();
        assertThat(tree.delete(myThirdWine)).isNotNull();
        assertThat(tree.contains(myThirdWine)).isFalse();
    }


    @Test
    void deleteTwoChildren() {
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.add(mySecondWine)).isNotNull();
        assertThat(tree.add(myThirdWine)).isNotNull();
        assertThat(tree.add(myFourthWine)).isNotNull();
        assertThat(tree.add(myFifthWine)).isNotNull();
        assertThat(tree.add(mySixthWine)).isNotNull();
        assertThat(tree.contains(mySecondWine)).isTrue();
        assertThat(tree.delete(mySecondWine)).isNotNull();
        assertThat(tree.contains(mySecondWine)).isFalse();
        assertThat(tree.contains(myThirdWine)).isTrue();
    }



    @Test
    void inOrder() {
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.add(mySecondWine)).isNotNull();
        assertThat(tree.add(myThirdWine)).isNotNull();
        assertThat(tree.add(myFourthWine)).isNotNull();
        assertThat(tree.add(myFifthWine)).isNotNull();
        assertThat(tree.contains(myFourthWine)).isTrue();
        assertThat(tree.display(Order.INORDER));
        assertThat(tree.toString()).isNotBlank().isEqualTo("[Wine(name=St Thomas, kind=red, pH=3.26, alcohol=0.54, quality=7), Wine(name=Albarolo, kind=red, pH=3.28, alcohol=0.46, quality=5), Wine(name=Shiraz, kind=red, pH=3.3, alcohol=0.57, quality=6), Wine(name=Adobe Guadalupe, kind=red, pH=3.51, alcohol=0.56, quality=5), Wine(name=Chardonnay, kind=white, pH=3.22, alcohol=9.5, quality=6)]");
    }

    @Test
    void preOrder() {
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.add(mySecondWine)).isNotNull();
        assertThat(tree.add(myThirdWine)).isNotNull();
        assertThat(tree.add(myFourthWine)).isNotNull();
        assertThat(tree.add(myFifthWine)).isNotNull();
        assertThat(tree.contains(myFourthWine)).isTrue();
        assertThat(tree.display(Order.PREORDER));
        assertThat(tree.toString()).isNotBlank().isEqualTo("[Wine(name=Adobe Guadalupe, kind=red, pH=3.51, alcohol=0.56, quality=5), Wine(name=St Thomas, kind=red, pH=3.26, alcohol=0.54, quality=7), Wine(name=Albarolo, kind=red, pH=3.28, alcohol=0.46, quality=5), Wine(name=Shiraz, kind=red, pH=3.3, alcohol=0.57, quality=6), Wine(name=Chardonnay, kind=white, pH=3.22, alcohol=9.5, quality=6)]");
    }

    @Test
    void postOrder() {
        assertThat(tree.add(myFirstWine)).isNotNull();
        assertThat(tree.add(mySecondWine)).isNotNull();
        assertThat(tree.add(myThirdWine)).isNotNull();
        assertThat(tree.add(myFourthWine)).isNotNull();
        assertThat(tree.add(myFifthWine)).isNotNull();
        assertThat(tree.contains(myFourthWine)).isTrue();
        assertThat(tree.display(Order.POSTORDER));
        assertThat(tree.toString()).isNotBlank().isEqualTo("[Wine(name=St Thomas, kind=red, pH=3.26, alcohol=0.54, quality=7), Wine(name=Albarolo, kind=red, pH=3.28, alcohol=0.46, quality=5), Wine(name=Shiraz, kind=red, pH=3.3, alcohol=0.57, quality=6), Wine(name=Chardonnay, kind=white, pH=3.22, alcohol=9.5, quality=6), Wine(name=Adobe Guadalupe, kind=red, pH=3.51, alcohol=0.56, quality=5)]");
    }

}