/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author fidel_li91s8o
 */

/**
 * Interfaz que indica que un producto puede recibir un descuento.
 * Las clases que implementen Descontable deben definir el método aplicarDescuento.
 */
public interface Descontable {

    /**
     * Aplica un descuento porcentual al precio del producto.
     * @param porcentaje valor del descuento a aplicar
     */
    void aplicarDescuento(double porcentaje);
}
