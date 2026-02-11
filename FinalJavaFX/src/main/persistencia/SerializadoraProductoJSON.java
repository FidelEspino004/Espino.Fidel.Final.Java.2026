/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import modelo.Producto;
import modelo.CategoriaProducto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializadoraProductoJSON {

    public void guardar(String ruta, List<Producto> productos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {

            pw.println("[");
            for (int i = 0; i < productos.size(); i++) {
                Producto p = productos.get(i);

                pw.println("  {");
                pw.println("    \"codigo\": \"" + p.getCodigo() + "\",");
                pw.println("    \"nombre\": \"" + p.getNombre() + "\",");
                pw.println("    \"precio\": " + p.getPrecio() + ",");
                pw.println("    \"categoria\": \"" + p.getCategoria() + "\"");
                pw.print("  }");

                if (i < productos.size() - 1) pw.println(",");
                else pw.println();
            }
            pw.println("]");

        } catch (IOException e) {
            System.out.println("Error al guardar JSON.");
        }
    }

    public List<Producto> leer(String ruta) {
        List<Producto> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            String codigo = "", nombre = "";
            double precio = 0;
            CategoriaProducto categoria = null;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("\"codigo\""))
                    codigo = linea.split(":")[1].replace("\"", "").replace(",", "").trim();

                else if (linea.startsWith("\"nombre\""))
                    nombre = linea.split(":")[1].replace("\"", "").replace(",", "").trim();

                else if (linea.startsWith("\"precio\""))
                    precio = Double.parseDouble(linea.split(":")[1].replace(",", "").trim());

                else if (linea.startsWith("\"categoria\"")) {
                    categoria = CategoriaProducto.valueOf(
                            linea.split(":")[1].replace("\"", "").trim()
                    );
                    lista.add(new Producto(nombre, codigo, precio, categoria));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer JSON.");
        }

        return lista;
    }
}
