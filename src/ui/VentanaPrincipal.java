package ui;

import java.util.List;
import comparadores.ProductoPorNombreComparator;
import comparadores.ProductoPorStockComparator;
import gestion.GestionProductos;
import modelo.Categoria;
import modelo.Producto;
import modelo.ProductoElectronico;
import modelo.ProductoAlimenticio;
import modelo.ProductoRopa;
import persistencias.ExportadorTXT;
import persistencias.PersistenciaBinaria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.io.IOException;

public class VentanaPrincipal extends BorderPane {

    private final GestionProductos gestion;
    private final ObservableList<Producto> datos;
    private TableView<Producto> tabla;

    public VentanaPrincipal(GestionProductos gestion) {
        this.gestion = gestion;
        this.datos = FXCollections.observableArrayList();
        crearUI();
        actualizarTabla();
    }

    private void crearUI() {

        tabla = new TableView<>(datos);

        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(c ->
                new javafx.beans.property.SimpleIntegerProperty(c.getValue().getId()).asObject());

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getNombre()));

        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(c ->
                new javafx.beans.property.SimpleDoubleProperty(c.getValue().getPrecio()).asObject());

        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(c ->
                new javafx.beans.property.SimpleIntegerProperty(c.getValue().getStock()).asObject());

        TableColumn<Producto, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(c -> {
            Producto p = c.getValue();
            if (p instanceof ProductoElectronico) {
                return new javafx.beans.property.SimpleStringProperty("Electrónico");
            } else if (p instanceof ProductoAlimenticio) {
                return new javafx.beans.property.SimpleStringProperty("Alimenticio");
            } else if (p instanceof ProductoRopa) {
                return new javafx.beans.property.SimpleStringProperty("Ropa");
            } else {
                return new javafx.beans.property.SimpleStringProperty("Desconocido");
            }
        });

        tabla.getColumns().addAll(colId, colNombre, colPrecio, colStock, colTipo);

        // ================= BOTONES =================

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> mostrarFormularioAgregar());

        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setOnAction(e -> eliminarProducto());

        Button btnOrdenNombre = new Button("Ordenar por Nombre");
        btnOrdenNombre.setOnAction(e -> {
            gestion.ordenar(new ProductoPorNombreComparator());
            actualizarTabla();
        });

        Button btnOrdenStock = new Button("Ordenar por Stock");
        btnOrdenStock.setOnAction(e -> {
            gestion.ordenar(new ProductoPorStockComparator());
            actualizarTabla();
        });

        Button btnGuardar = new Button("Guardar DAT");
        btnGuardar.setOnAction(e -> {
            try {
                PersistenciaBinaria.guardar("productos.dat", gestion.listar());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button btnCargar = new Button("Cargar DAT");
        btnCargar.setOnAction(e -> {
            try {
                List<Producto> productosCargados =
                        PersistenciaBinaria.cargar("productos.dat");

                // 🔥 CORRECCIÓN IMPORTANTE
                gestion.reemplazarLista(productosCargados);

                actualizarTabla();

            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Button btnExportarTXT = new Button("Exportar TXT");
        btnExportarTXT.setOnAction(e -> {
            try {
                ExportadorTXT.exportar("reporte.txt", gestion.listar());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        TextField txtFiltro = new TextField();
        txtFiltro.setPromptText("Filtrar por nombre");

        Button btnFiltrar = new Button("Filtrar");
        btnFiltrar.setOnAction(e -> {
            String texto = txtFiltro.getText();
            datos.setAll(gestion.filtrarPorNombre(texto));
        });

        VBox botones = new VBox(10,
                txtFiltro,
                btnFiltrar,
                btnAgregar,
                btnEliminar,
                btnOrdenNombre,
                btnOrdenStock,
                btnGuardar,
                btnCargar,
                btnExportarTXT
        );

        botones.setPadding(new Insets(10));

        setCenter(tabla);
        setRight(botones);
    }

    private void mostrarFormularioAgregar() {

        Stage ventana = new Stage();
        ventana.setTitle("Nuevo Producto");

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");

        TextField txtStock = new TextField();
        txtStock.setPromptText("Stock");

        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Electrónico", "Alimenticio", "Ropa");
        comboTipo.setValue("Electrónico");

        Button btnGuardar = new Button("Guardar");
        Button btnCancelar = new Button("Cancelar");

        btnGuardar.setOnAction(e -> {
            try {
                int id = gestion.listar().size() + 1;

                String nombre = txtNombre.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());
                String tipo = comboTipo.getValue();

                Producto nuevo;

                if (tipo.equals("Electrónico")) {
                    nuevo = new ProductoElectronico(
                            id, nombre, precio, stock,
                            Categoria.ELECTRONICA,
                            12, 220
                    );
                } else if (tipo.equals("Alimenticio")) {
                    nuevo = new ProductoAlimenticio(
                            id, nombre, precio, stock,
                            Categoria.ALIMENTOS,
                            LocalDate.of(2026, 1, 1),
                            false
                    );
                } else {
                    nuevo = new ProductoRopa(
                            id, nombre, precio, stock,
                            Categoria.ROPA,
                            "M",
                            "Algodón"
                    );
                }

                gestion.crear(nuevo);
                actualizarTabla();
                ventana.close();

            } catch (NumberFormatException ex) {
                System.out.println("Precio o stock inválido.");
            }
        });

        btnCancelar.setOnAction(e -> ventana.close());

        VBox layout = new VBox(10,
                txtNombre,
                txtPrecio,
                txtStock,
                comboTipo,
                btnGuardar,
                btnCancelar
        );

        layout.setPadding(new Insets(15));

        ventana.setScene(new Scene(layout, 300, 300));
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.showAndWait();
    }

    private void eliminarProducto() {

        Producto seleccionado = tabla.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            gestion.eliminar(seleccionado.getId());
            actualizarTabla();
        }
    }

    private void actualizarTabla() {
        datos.setAll(gestion.listar());
    }
}