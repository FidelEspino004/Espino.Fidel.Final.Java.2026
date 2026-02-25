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
import java.time.LocalDate;

public class ProductoAlimenticio extends Producto implements Descontable {

    private LocalDate fechaVencimiento;
    private boolean esOrganico;

    public ProductoAlimenticio(int id, String nombre, double precio, int stock,
                                Categoria categoria, LocalDate fechaVencimiento, boolean esOrganico) {
        super(id, nombre, precio, stock, categoria);
        this.fechaVencimiento = fechaVencimiento;
        this.esOrganico = esOrganico;
    }

    public ProductoAlimenticio(int id, String nombre, double precio,
                                Categoria categoria, LocalDate fechaVencimiento) {
        super(id, nombre, precio, categoria);
        this.fechaVencimiento = fechaVencimiento;
        this.esOrganico = false;
    }

    public ProductoAlimenticio() {}

    @Override
    public double calcularPrecioFinal() {
        return precio;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.precio -= this.precio * (porcentaje / 100);
    }
}
