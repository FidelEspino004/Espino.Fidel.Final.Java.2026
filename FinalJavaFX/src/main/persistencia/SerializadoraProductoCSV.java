/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Producto;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SerializadoraProductoCSV {

    public void exportar(String ruta, List<Producto> productos) {
        try (FileWriter fw = new FileWriter(ruta)) {

            // Encabezado
            fw.write("codigo,nombre,precio,categoria\n");

            // Filas
            for (Producto p : productos) {
                fw.write(
                    p.getCodigo() + "," +
                    p.getNombre() + "," +
                    p.getPrecio() + "," +
                    p.getCategoria() + "\n"
                );
            }

        } catch (IOException e) {
            System.out.println("Error al exportar CSV.");
        }
    }
}

