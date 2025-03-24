package com.example;

class BinarySearchTree {
    private Nodo root;

    public void insert(Producto product) {
        root = insertRec(root, product);
    }

    private Nodo insertRec(Nodo root, Producto product) {
        if (root == null) return new Nodo(product);
        if (product.sku.compareTo(root.product.sku) < 0) {
            root.left = insertRec(root.left, product);
        } else if (product.sku.compareTo(root.product.sku) > 0) {
            root.right = insertRec(root.right, product);
        }
        return root;
    }

    public Producto search(String sku) {
        return searchRec(root, sku);
    }

    private Producto searchRec(Nodo root, String sku) {
        if (root == null) return null;
        if (root.product.sku.equals(sku)) return root.product;
        return sku.compareTo(root.product.sku) < 0 ? searchRec(root.left, sku) : searchRec(root.right, sku);
    }
}
