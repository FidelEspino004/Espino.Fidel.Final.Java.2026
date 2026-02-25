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

public class ProductoPorNombreComparator implements Comparator<Producto> {

    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}