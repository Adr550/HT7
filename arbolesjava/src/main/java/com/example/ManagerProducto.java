package com.example;
import java.io.*;


class ManagerProducto {
    private BinarySearchTree<Producto> bab;

    public ManagerProducto() {
        this.bab = new BinarySearchTree<>();
    }

   
    public void loadProducts(String filePath) {
        String CSVReader = "src/main/resources/home_appliance_skus_lowes.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(CSVReader))) {
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
                bab.insert(product);
            }

            System.out.println("Productos cargados al arbol.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar los productos: " + e.getMessage());
        }
    }

    public Producto searchProduct(String skuString) {
        try {
            int sku = Integer.parseInt(skuString);
            return bab.search(new Producto(sku, 0, 0, "", ""));
        } catch (NumberFormatException e) {
            System.err.println("Error: SKU inválido.");
            return null;
        }
    }
}
