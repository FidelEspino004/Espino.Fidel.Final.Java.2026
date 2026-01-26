/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparadores;

import modelo.Producto;
import java.util.Comparator;

public class ComparadorCodigoProducto implements Comparator<Producto> {

    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getCodigo().compareToIgnoreCase(p2.getCodigo());
    }
}

