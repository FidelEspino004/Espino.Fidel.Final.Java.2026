/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

/**
 *
 * @author fidel_li91s8o
 */

import java.util.Iterator;
import java.util.List;
import modelo.Producto;

public class ProductoIterator implements Iterator<Producto> {

    private List<Producto> lista;
    private int posicion = 0;

    public ProductoIterator(List<Producto> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return posicion < lista.size();
    }

    @Override
    public Producto next() {
        return lista.get(posicion++);
    }
}
