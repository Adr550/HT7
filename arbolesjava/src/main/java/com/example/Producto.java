package com.example;


class Producto {
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
    public String toString() {
        return "SKU: " + sku + ", Price_Current: " + priceCurrent + ", Price_Retail: " + priceRetail + ", Name: " + productName + ", Category: " + category;
    }
}
