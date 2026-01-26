/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import gestor.DepositoProductos;
import modelo.*;
import comparadores.*;
import persistencia.SerializadoraProducto;
import persistencia.SerializadoraProductoCSV;
import persistencia.SerializadoraProductoJSON;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DepositoProductos deposito = new DepositoProductos();

        try {
            // --- Agregar productos ---
            deposito.agregar(new Producto("Arroz", "A1", 1200, CategoriaProducto.ALIMENTO));
            deposito.agregar(new Producto("Televisor", "E1", 250000, CategoriaProducto.ELECTRONICA));
            deposito.agregar(new Producto("Lavandina", "L1", 900, CategoriaProducto.LIMPIEZA));

            // --- Listar ---
            System.out.println("Listado:");
            for (Producto p : deposito) {
                System.out.println(p);
            }

            // --- Ordenar ---
            deposito.ordenar(new ComparadorPrecioProducto());
            System.out.println("\nOrdenado por precio:");
            for (Producto p : deposito) {
                System.out.println(p);
            }

            // --- BINARIO ---
            SerializadoraProducto bin = new SerializadoraProducto();
            bin.guardar("productos.dat", new ArrayList<>(deposito.listar()));

            ArrayList<Producto> cargados = bin.leer("productos.dat");
            System.out.println("\nProductos cargados desde BIN:");
            for (Producto p : cargados) {
                System.out.println(p);
            }

            // --- CSV ---
            SerializadoraProductoCSV csv = new SerializadoraProductoCSV();
            csv.exportar("productos.csv", deposito.listar());

            // --- JSON ---
            SerializadoraProductoJSON json = new SerializadoraProductoJSON();
            json.guardar("productos.json", deposito.listar());

            System.out.println("\nProductos cargados desde JSON:");
            for (Producto p : json.leer("productos.json")) {
                System.out.println(p);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


