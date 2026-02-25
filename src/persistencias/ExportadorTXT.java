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
import java.time.LocalDateTime;
import java.util.List;

public class ExportadorTXT {

    public static void exportar(String ruta, List<Producto> lista) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {

            writer.write("===== LISTADO DE PRODUCTOS =====");
            writer.newLine();
            writer.write("Fecha de exportación: " + LocalDateTime.now());
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();

            for (Producto p : lista) {
                writer.write(p.toString());
                writer.newLine();
            }

            writer.write("----------------------------------------");
            writer.newLine();
            writer.write("Total de productos: " + lista.size());
        }
    }
}