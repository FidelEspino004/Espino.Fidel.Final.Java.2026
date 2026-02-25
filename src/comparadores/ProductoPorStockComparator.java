/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparadores;

/**
 *
 * @author fidel_li91s8o
 */

import modelo.Producto;
import java.util.Comparator;

/**
 * Comparator para ordenar productos por cantidad de stock.
 */
public class ProductoPorStockComparator implements Comparator<Producto> {

    @Override
    public int compare(Producto p1, Producto p2) {
        // Compara la cantidad de stock de ambos productos
        return Integer.compare(p1.getStock(), p2.getStock());
    }
}
