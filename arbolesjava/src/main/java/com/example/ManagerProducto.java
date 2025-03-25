package com.example;
import java.io.*;
import java.util.*;

class ManagerProducto {
    private BinarySearchTree<Producto> bst;

    public ManagerProducto() {
        this.bst = new BinarySearchTree<>();
    }

   
    public void loadProducts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int sku = Integer.parseInt(data[0].trim());
                double priceRetail = Double.parseDouble(data[1].trim());
                double priceCurrent = Double.parseDouble(data[2].trim());
                String productName = data[3].trim();
                String category = data[4].trim();

                Producto product = new Producto(sku, priceRetail, priceCurrent, productName, category);
                bst.insert(product);
            }

            System.out.println("Productos cargados en el BST.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar los productos: " + e.getMessage());
        }
    }

    public Producto searchProduct(String skuString) {
        try {
            int sku = Integer.parseInt(skuString);
            return bst.search(new Producto(sku, 0, 0, "", ""));
        } catch (NumberFormatException e) {
            System.err.println("Error: SKU inválido.");
            return null;
        }
    }
}
