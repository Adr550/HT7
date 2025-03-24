package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerProducto manager = new ManagerProducto();
        String filePath = "src/main/resources/home_appliance_skus_lowes.csv";
        manager.loadProducts(filePath);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese SKU para buscar: ");
        String sku = scanner.nextLine();
        Producto result = manager.searchProduct(sku);
        System.out.println(result != null ? result : "Producto no encontrado.");
    }
}