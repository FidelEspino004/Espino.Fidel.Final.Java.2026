/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

/**
 *
 * @author fidel_li91s8o
 */

import excepciones.ProductoNoEncontradoException;
import interfaces.Repositorio;
import modelo.Producto;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GestionProductos implements Repositorio<Producto>, Iterable<Producto> {

    private List<Producto> lista;

    public GestionProductos() {
        lista = new ArrayList<>();
    }

    // CRUD

    @Override
    public void crear(Producto entidad) {
        lista.add(entidad);
    }

    @Override
    public void actualizar(int id, Producto entidad) {
        Producto existente = buscarPorId(id);
        lista.set(lista.indexOf(existente), entidad);
    }

    @Override
    public void eliminar(int id) {
        Producto p = buscarPorId(id);
        lista.remove(p);
    }

    @Override
    public Producto buscarPorId(int id) {
        return lista.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado"));
    }

    @Override
    public List<Producto> listar() {
        return new ArrayList<>(lista);
    }

    // Iterator personalizado
    @Override
    public Iterator<Producto> iterator() {
        return new ProductoIterator(lista);
    }

    // Orden natural (Comparable)
    public void ordenarNatural() {
        Collections.sort(lista);
    }

    // Orden con Comparator
    public void ordenar(Comparator<Producto> comparator) {
        lista.sort(comparator);
    }

    // Filtrado con wildcard simple (*texto*)
    public List<Producto> filtrarPorNombre(String texto) {
        String patron = texto.replace("*", "").toLowerCase();

        return lista.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(patron))
                .collect(Collectors.toList());
    }

    // Uso de interfaz funcional
    public void aplicarOperacion(Consumer<Producto> operacion) {
        lista.forEach(operacion);
    }

    // Wildcard ? extends
    public void imprimirLista(List<? extends Producto> productos) {
        productos.forEach(System.out::println);
    }

    // Wildcard ? super
    public void agregarProductos(List<? super Producto> destino) {
        destino.addAll(lista);
    }
    
    public void reemplazarLista(List<Producto> nuevaLista) {
        lista.clear();
        lista.addAll(nuevaLista);
    }
}