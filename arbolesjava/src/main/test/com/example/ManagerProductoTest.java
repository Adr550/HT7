package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerProductoTest {
    private ManagerProducto manager;

    @BeforeEach
    void setUp() {
        manager = new ManagerProducto();

        manager.loadProducts("home appliance skus lowes.csv");
    }

    @Test
    void testBusqueda_SKU_Existente() {
        Producto result = manager.searchProduct("1000025525");
        assertNotNull(result);
        assertEquals("1000025525", result.sku);
        System.out.println("Producto encontrado: " + result);
    }

    @Test
    void testBusqueda_SKU_Inventado() {
        Producto result = manager.searchProduct("2");
        assertNull(result);
    }
}