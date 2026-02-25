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

    /**
     * Guarda la lista de productos en un archivo CSV.
     * @param ruta ruta del archivo .csv
     * @param lista lista de productos a guardar
     * @throws IOException si hay error de escritura
     */
    public static void guardar(String ruta, List<Producto> lista) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {

            // Escribe la cabecera
            writer.write("ID,Nombre,Precio,Stock,Categoria");
            writer.newLine();

            // Escribe cada producto separado por comas
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