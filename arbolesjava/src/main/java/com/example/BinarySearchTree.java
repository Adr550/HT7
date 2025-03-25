package com.example;

class BinarySearchTree<T extends Comparable<T>> {
    private Nodo<T> root;

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Nodo<T> insertRec(Nodo<T> root, T prodcut) {
        if (root == null) return new Nodo<>(prodcut);

        if (prodcut.compareTo(root.product) < 0) {
            root.left = insertRec(root.left, prodcut);
        } else if (prodcut.compareTo(root.product) > 0) {
            root.right = insertRec(root.right, prodcut);
        }
        return root;
    }

    public T search(T prodcut) {
        return searchRec(root, prodcut);
    }

    private T searchRec(Nodo<T> root, T product) {
        if (root == null) return null;
        if (root.product.equals(product)) return root.product;
        return product.compareTo(root.product) < 0 ? searchRec(root.left, product) : searchRec(root.right, product);
    }
}
