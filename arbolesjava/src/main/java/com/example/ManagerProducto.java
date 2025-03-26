package com.example;
import java.io.*;

class ManagerProducto {
    private BinarySearchTree<Producto> bab;

    public ManagerProducto() {
        this.bab = new BinarySearchTree<>();
    }

    public void loadProducts(String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                throw new FileNotFoundException("Could not find file: " + fileName);
            }

            String line;

            br.readLine();

            int productCount = 0;
            int skippedCount = 0;

            while ((line = br.readLine()) != null) {

                String[] data = parseCSVLine(line);

                if (data.length < 11) {
                    System.err.println("Skipping invalid line: " + line);
                    skippedCount++;
                    continue;
                }

                try {

                    String sku = data[6].trim();

                    // Handle empty price fields
                    double priceRetail = data[9].trim().isEmpty() ? 0.0 : Double.parseDouble(data[9].trim());
                    double priceCurrent = data[10].trim().isEmpty() ? 0.0 : Double.parseDouble(data[10].trim());

                    String productName = data[19].trim();
                    String category = data[0].trim();

                    Producto product = new Producto(sku, priceRetail, priceCurrent, productName, category);
                    bab.insert(product);
                    productCount++;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error parsing line: " + line);
                    skippedCount++;
                    e.printStackTrace();
                }
            }

            System.out.println("Productos cargados al arbol: " + productCount);
            System.out.println("Productos omitidos: " + skippedCount);
        } catch (IOException e) {
            System.err.println("Error al cargar los productos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Prompt: Como puede mi Managerproduct leer CSVS con espacios en blanco y combinaciones alphanumericas
    private String[] parseCSVLine(String line) {

        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();
        java.util.List<String> fields = new java.util.ArrayList<>();

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(sb.toString().trim());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        fields.add(sb.toString().trim());

        return fields.toArray(new String[0]);
    }

    public Producto searchProduct(String skuString) {
        return bab.search(new Producto(skuString, 0, 0, "", ""));
    }
}