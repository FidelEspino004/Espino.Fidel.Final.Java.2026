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

public class App extends Application {

    private GestionProductos gestion = new GestionProductos();

    @Override
    public void start(Stage stage) {

        VentanaPrincipal root = new VentanaPrincipal(gestion);

        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("CRUD - Gestión de Productos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}