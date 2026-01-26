/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import interfaces.Manipulable;
import modelo.Producto;
import excepciones.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DepositoProductos implements Manipulable<Producto>, Iterable<Producto> {

    private ArrayList<Producto> productos;

    public DepositoProductos() {
        this.productos = new ArrayList<>();
    }

    @Override
    public void agregar(Producto p) throws ProductoDuplicadoException {
        if (productos.contains(p)) {
            throw new ProductoDuplicadoException("El producto ya existe.");
        }
        productos.add(p);
    }

    @Override
    public void eliminar(Producto p) throws ProductoNoEncontradoException {
        if (!productos.remove(p)) {
            throw new ProductoNoEncontradoException("Producto no encontrado.");
        }
    }

    @Override
    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    public Producto buscarPorCodigo(String codigo) throws ProductoNoEncontradoException {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("No se encontró el producto.");
    }

    public void ordenar(Comparator<Producto> comp) {
        productos.sort(comp);
    }

    @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
}


