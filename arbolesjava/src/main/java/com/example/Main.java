package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerProducto manager = new ManagerProducto();
        String filePath = "home appliance skus lowes.csv";
        manager.loadProducts(filePath);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese SKU para buscar el producto: ");
        String sku = scanner.nextLine();
        Producto result = manager.searchProduct(sku);
        System.out.println(result != null ? result : "producto no encontrado.");
    }
}