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

public interface Repositorio<T> {

    void crear(T entidad);

    void actualizar(int id, T entidad);

    void eliminar(int id);

    T buscarPorId(int id);

    List<T> listar();
}
