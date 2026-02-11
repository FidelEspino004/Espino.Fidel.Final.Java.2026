package espino.fidel.finaljavafx;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import modelo.*;
import gestor.*;
import persistencia.*;
import comparadores.*;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        DepositoProductos deposito = new DepositoProductos();

        //  Tabla
        TableView<Producto> tabla = new TableView<>();

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre())
        );

        TableColumn<Producto, String> colCodigo = new TableColumn<>("Código");
        colCodigo.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getCodigo())
        );

        TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrecio())
        );

        tabla.getColumns().addAll(colNombre, colCodigo, colPrecio);

        // Campos
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtCodigo = new TextField();
        txtCodigo.setPromptText("Código");

        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");

        ComboBox<CategoriaProducto> comboCategoria = new ComboBox<>();
        comboCategoria.getItems().addAll(CategoriaProducto.values());
        comboCategoria.setValue(CategoriaProducto.ALIMENTO);

        Button btnAgregar = new Button("Agregar");
        // aagregar
        btnAgregar.setOnAction(e -> {
            try {
                Producto p = new Producto(
                        txtNombre.getText(),
                        txtCodigo.getText(),
                        Double.parseDouble(txtPrecio.getText()),
                        comboCategoria.getValue()
                );

                deposito.agregar(p);
                tabla.getItems().add(p);

                txtNombre.clear();
                txtCodigo.clear();
                txtPrecio.clear();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        // eliminar 
        Button btnEliminar = new Button("Eliminar seleccionado");

        btnEliminar.setOnAction(e -> {
            Producto seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                try {
                    deposito.eliminar(seleccionado);
                    tabla.getItems().remove(seleccionado);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        // ordenaar 
        Button btnOrdenar = new Button("Ordenar por Precio");

        btnOrdenar.setOnAction(e -> {
            deposito.ordenar(new ComparadorPrecioProducto());
            tabla.getItems().clear();
            tabla.getItems().addAll(deposito.listar());
        });
        // Guardar 
        Button btnGuardar = new Button("Guardar BIN");

        btnGuardar.setOnAction(e -> {
            SerializadoraProducto sp = new SerializadoraProducto();
            sp.guardar("productos.dat", new java.util.ArrayList<>(deposito.listar()));
        });
        // Cargar 
        Button btnCargar = new Button("Cargar BIN");

        btnCargar.setOnAction(e -> {
            SerializadoraProducto sp = new SerializadoraProducto();
            java.util.ArrayList<Producto> lista = sp.leer("productos.dat");

            tabla.getItems().clear();
            tabla.getItems().addAll(lista);
        });

        VBox root = new VBox(10, txtNombre, txtCodigo, txtPrecio,
                comboCategoria, btnAgregar, btnEliminar, btnOrdenar, btnGuardar, btnCargar, tabla);

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("Gestión de Productos");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}