/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fidel_li91s8o
 */

import java.io.Serializable;

public abstract class Producto implements Comparable<Producto>, Serializable {

    private static final long serialVersionUID = 1L;

    protected int id;
    protected String nombre;
    protected double precio;
    protected int stock;
    protected Categoria categoria;

    // Constructor completo
    public Producto(int id, String nombre, double precio, int stock, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Constructor sin stock
    public Producto(int id, String nombre, double precio, Categoria categoria) {
        this(id, nombre, precio, 0, categoria);
    }

    // Constructor vacío (necesario para JSON)
    public Producto() {
    }

    // Método abstracto
    public abstract double calcularPrecioFinal();

    public void aumentarStock(int cantidad) {
        this.stock += cantidad;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    public String descripcion() {
        return id + " - " + nombre + " - $" + precio + " - Stock: " + stock;
    }

    // Orden natural por precio
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public Categoria getCategoria() { return categoria; }

    // Setters
    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return descripcion();
    }
}
