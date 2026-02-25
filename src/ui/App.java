/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author fidel_li91s8o
 */

import gestion.GestionProductos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación JavaFX.
 * Extiende Application para usar la GUI de JavaFX.
 */
public class App extends Application {

    // Instancia de GestionProductos para manejar los productos en toda la app
    private GestionProductos gestion = new GestionProductos();

    @Override
    public void start(Stage stage) {

        // Crea la ventana principal pasando la gestión de productos
        VentanaPrincipal root = new VentanaPrincipal(gestion);

        // Crea la escena principal con tamaño 900x600
        Scene scene = new Scene(root, 900, 600);

        // Configura la ventana (Stage)
        stage.setTitle("CRUD - Gestión de Productos"); // título de la ventana
        stage.setScene(scene); // asigna la escena
        stage.show(); // muestra la ventana
    }

    /**
     * Método principal que inicia la aplicación.
     * @param args argumentos de línea de comando (no usados)
     */
    public static void main(String[] args) {
        launch(); // inicia la aplicación JavaFX
    }
}