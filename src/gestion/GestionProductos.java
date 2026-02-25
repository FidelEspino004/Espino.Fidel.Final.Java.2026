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

/**
 * Clase principal que gestiona los productos.
 * Implementa la interfaz Repositorio para CRUD y Iterable para iteración.
 */
public class GestionProductos implements Repositorio<Producto>, Iterable<Producto> {

    private List<Producto> lista; // lista interna de productos

    public GestionProductos() {
        lista = new ArrayList<>();
    }

    // ================= CRUD =================

    @Override
    public void crear(Producto entidad) {
        lista.add(entidad); // agrega un producto nuevo
    }

    @Override
    public void actualizar(int id, Producto entidad) {
        Producto existente = buscarPorId(id); // busca el producto por ID
        lista.set(lista.indexOf(existente), entidad); // reemplaza el producto
    }

    @Override
    public void eliminar(int id) {
        Producto p = buscarPorId(id);
        lista.remove(p); // elimina el producto
    }

    @Override
    public Producto buscarPorId(int id) {
        // Busca un producto por su ID, lanza excepción si no existe
        return lista.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado"));
    }

    @Override
    public List<Producto> listar() {
        // Devuelve copia de la lista para no exponer la lista interna
        return new ArrayList<>(lista);
    }

    // ================= Iterador =================
    @Override
    public Iterator<Producto> iterator() {
        return new ProductoIterator(lista); // iterador personalizado
    }

    // ================= Orden =================

    // Ordena por orden natural (Comparable)
    public void ordenarNatural() {
        Collections.sort(lista);
    }

    // Ordena usando un Comparator
    public void ordenar(Comparator<Producto> comparator) {
        lista.sort(comparator);
    }

    // ================= Filtrado =================

    // Filtra productos por nombre usando wildcard simple
    public List<Producto> filtrarPorNombre(String texto) {
        String patron = texto.replace("*", "").toLowerCase();
        return lista.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(patron))
                .collect(Collectors.toList());
    }

    // ================= Operaciones funcionales =================

    // Aplica una operación a cada producto (por ejemplo, aumentar stock)
    public void aplicarOperacion(Consumer<Producto> operacion) {
        lista.forEach(operacion);
    }

    // Imprime productos de cualquier lista que sea ? extends Producto
    public void imprimirLista(List<? extends Producto> productos) {
        productos.forEach(System.out::println);
    }

    // Agrega productos a una lista que acepte ? super Producto
    public void agregarProductos(List<? super Producto> destino) {
        destino.addAll(lista);
    }

    // Reemplaza la lista interna por otra lista
    public void reemplazarLista(List<Producto> nuevaLista) {
        lista.clear();
        lista.addAll(nuevaLista);
    }
}