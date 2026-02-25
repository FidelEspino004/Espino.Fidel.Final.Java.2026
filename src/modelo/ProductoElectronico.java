/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fidel_li91s8o
 */

public class ProductoElectronico extends Producto {

    private int garantiaMeses;
    private int voltaje;

    public ProductoElectronico(int id, String nombre, double precio, int stock,
                                Categoria categoria, int garantiaMeses, int voltaje) {
        super(id, nombre, precio, stock, categoria);
        this.garantiaMeses = garantiaMeses;
        this.voltaje = voltaje;
    }

    public ProductoElectronico(int id, String nombre, double precio,
                                Categoria categoria, int garantiaMeses) {
        super(id, nombre, precio, categoria);
        this.garantiaMeses = garantiaMeses;
        this.voltaje = 220;
    }

    public ProductoElectronico() {}

    @Override
    public double calcularPrecioFinal() {
        return precio * 1.21; // IVA ejemplo
    }
}
