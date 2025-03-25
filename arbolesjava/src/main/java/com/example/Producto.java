package com.example;

class Producto implements Comparable<Producto> {
    int sku;
    double priceRetail;
    double priceCurrent;
    String productName;
    String category;

    public Producto(int sku, double priceRetail, double priceCurrent, String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Producto other) {
        return Integer.compare(this.sku, other.sku);
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Price_Current: " + priceCurrent + ", Price_Retail: " + priceRetail +
               ", Name: " + productName + ", Category: " + category;
    }
}
