/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

public class Producto implements Comparable<Producto>, Serializable {

    private String nombre;
    private String codigo;
    private double precio;
    private CategoriaProducto categoria;

    // Constructor completo
    public Producto(String nombre, String codigo, double precio, CategoriaProducto categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Constructor con un parámetro menos
    public Producto(String nombre, String codigo, double precio) {
        this(nombre, codigo, precio, CategoriaProducto.ALIMENTO);
    }

    // Constructor a elección
    public Producto(String codigo) {
        this.codigo = codigo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Orden natural (Comparable)
    @Override
    public int compareTo(Producto otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Producto)) return false;
        Producto otro = (Producto) obj;
        return this.codigo.equalsIgnoreCase(otro.codigo);
    }
}


