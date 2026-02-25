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

    public static void guardar(String ruta, List<Producto> lista) throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ruta))) {

            oos.writeObject(lista);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Producto> cargar(String ruta)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(ruta))) {

            return (List<Producto>) ois.readObject();
        }
    }
}
