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

public class PersistenciaCSV {

    public static void guardar(String ruta, List<Producto> lista) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {

            writer.write("ID,Nombre,Precio,Stock,Categoria");
            writer.newLine();

            for (Producto p : lista) {
                writer.write(p.getId() + "," +
                        p.getNombre() + "," +
                        p.getPrecio() + "," +
                        p.getStock() + "," +
                        p.getCategoria());
                writer.newLine();
            }
        }
    }
}