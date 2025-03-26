package com.example;

class Producto implements Comparable<Producto> {
    String sku;
    double priceRetail;
    double priceCurrent;
    String productName;
    String category;

    public Producto(String sku, double priceRetail, double priceCurrent, String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Producto other) {
        return this.sku.compareTo(other.sku);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return sku.equals(producto.sku);
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Price_Current: " + priceCurrent + ", Price_Retail: " + priceRetail +
                ", Name: " + productName + ", Category: " + category;
    }
}