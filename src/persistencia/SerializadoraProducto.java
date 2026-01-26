/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import interfaces.Serializadora;
import modelo.Producto;
import java.io.*;
import java.util.ArrayList;

public class SerializadoraProducto implements Serializadora<ArrayList<Producto>> {

    @Override
    public void guardar(String ruta, ArrayList<Producto> datos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(datos);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    @Override
    public ArrayList<Producto> leer(String ruta) {
        ArrayList<Producto> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            lista = (ArrayList<Producto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer archivo.");
        }
        return lista;
    }
}
