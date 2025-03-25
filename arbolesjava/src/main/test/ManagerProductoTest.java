package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerProductoTest {
    private ManagerProducto manager;

    @BeforeEach
    void setUp() {
        manager = new ManagerProducto();
        manager.loadProducts("src/main/resources/home_appliance_skus_lowes.csv");
    }

    @Test
    void testBusqueda_SKU_Existente() {
        Producto result = manager.searchProduct("1000025525"); 
        assertNotNull(result);
        System.out.println("Producto encontrado: " + result);
    }

    @Test
    void testBusqueda_SKU_Inventado() {
        Producto result = manager.searchProduct("2"); 
        assertNull(result);
    }
}
