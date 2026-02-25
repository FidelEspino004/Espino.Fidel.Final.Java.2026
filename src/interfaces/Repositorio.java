/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author fidel_li91s8o
 */
import java.util.List;

/**
 * Interfaz genérica para operaciones CRUD.
 * GestionProductos implementa esta interfaz.
 * @param <T> Tipo de entidad que se va a gestionar (Producto en este proyecto)
 */
public interface Repositorio<T> {

    void crear(T entidad); 
    void actualizar(int id, T entidad); 
    void eliminar(int id); 
    T buscarPorId(int id); // Devuelve la entidad que coincide con el ID
    List<T> listar(); // Devuelve todas las entidades
}