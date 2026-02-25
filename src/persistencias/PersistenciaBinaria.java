/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencias;

/**
 *
 * @author fidel_li91s8o
 */
import modelo.Producto;
import java.io.*;
import java.util.List;

public class PersistenciaBinaria {

    /**
     * Guarda la lista de productos en un archivo binario.
     * @param ruta ruta del archivo .dat
     * @param lista lista de productos a guardar
     * @throws IOException si ocurre un error de escritura
     */
    public static void guardar(String ruta, List<Producto> lista) throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(lista); // serializa la lista completa
        }
    }

    /**
     * Carga la lista de productos desde un archivo binario.
     * @param ruta ruta del archivo .dat
     * @return lista de productos cargada
     * @throws IOException si hay error al leer
     * @throws ClassNotFoundException si la clase Producto no se encuentra
     */
    @SuppressWarnings("unchecked")
    public static List<Producto> cargar(String ruta) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<Producto>) ois.readObject(); // deserializa la lista
        }
    }
}
