package com.example;

class Nodo<T> {
    T product;
    Nodo<T> left, right;

    public Nodo(T product) {
        this.product = product;
        this.left = this.right = null;
    }
}
