package com.lanceliu.study;

import java.io.PrintStream;

class BSTnode<K> {
    // *** fields ***
    private K key;
    private BSTnode<K> left, right;

    // *** constructor ***
    public BSTnode(K key, BSTnode<K> left, BSTnode<K> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    // *** methods ***

    // accessors (access to fields)
    public K getKey() { return key; }
    public BSTnode<K> getLeft() { return left; }
    public BSTnode<K> getRight() { return right; }


    // mutators (change fields)
    public void setKey(K newK) { key = newK; }
    public void setLeft(BSTnode<K> newL) { left = newL; }
    public void setRight(BSTnode<K> newR) { right = newR; }
}

public class BST<K extends Comparable<K>> {
    // *** fields ***
    private BSTnode<K> root; // ptr to the root of the BST

    // *** constructor ***
    public BST() { root = null; }

    // *** methods ***

    public void insert(K key) throws Exception {  }
    // add key to this BST; error if it is already there

    public void delete(K key) {  }
    // remove the node containing key from this BST if it is there;
    // otherwise, do nothing

    public boolean lookup(K key) {  return false;}
    // if key is in this BST, return true; otherwise, return false

    public void print(PrintStream p) {  }
    // print the values in this BST in sorted order (to p)
}