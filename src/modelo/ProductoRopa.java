/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fidel_li91s8o
 */

import interfaces.Descontable;

public class ProductoRopa extends Producto implements Descontable {

    private String talle;
    private String material;

    public ProductoRopa(int id, String nombre, double precio, int stock,
                         Categoria categoria, String talle, String material) {
        super(id, nombre, precio, stock, categoria);
        this.talle = talle;
        this.material = material;
    }

    public ProductoRopa(int id, String nombre, double precio,
                         Categoria categoria, String talle) {
        super(id, nombre, precio, categoria);
        this.talle = talle;
        this.material = "Algodón";
    }

    public ProductoRopa() {}

    @Override
    public double calcularPrecioFinal() {
        return precio;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.precio -= this.precio * (porcentaje / 100);
    }
}
