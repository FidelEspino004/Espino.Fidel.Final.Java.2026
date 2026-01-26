/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.List;
import excepciones.ProductoDuplicadoException;
import excepciones.ProductoNoEncontradoException;

public interface Manipulable<T> {

    void agregar(T t) throws ProductoDuplicadoException;

    void eliminar(T t) throws ProductoNoEncontradoException;

    List<T> listar();
}

