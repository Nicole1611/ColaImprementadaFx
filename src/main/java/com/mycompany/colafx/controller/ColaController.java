package com.mycompany.colafx.controller;

import com.mycompany.colafx.model.Cola;
import com.mycompany.colafx.view.ColaCanvas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.List;

public class ColaController {

    @FXML
    private TextField txtValor;
    @FXML
    private Label lblEstado;
    @FXML
    private StackPane canvasHolder;

    private Cola cola;
    private ColaCanvas canvas;

    @FXML
    private void initialize() {
        cola = new Cola();
        canvas = new ColaCanvas();
        canvasHolder.getChildren().add(canvas);

        lblEstado.setText("Cola inicializada (vacía)");
        refreshView();
    }

    @FXML
    private void encolar() {
        String texto = txtValor.getText().trim();
        if (texto.isEmpty()) return;

        int valor = Integer.parseInt(texto);
        cola.encolar(valor);

        lblEstado.setText("Valor encolado: " + valor);
        txtValor.clear();
        txtValor.requestFocus();
        refreshView();
    }

    @FXML
    private void desencolar() {
        Integer valor = cola.desencolar();

        if (valor == null) {
            lblEstado.setText("La cola está vacía");
        } else {
            lblEstado.setText("Valor desencolado: " + valor);
        }
        refreshView();
    }

    @FXML
    private void peek() {
        Integer valor = cola.peek();
        lblEstado.setText(valor == null ? "La cola está vacía" : "Frente de la cola: " + valor);
    }

    @FXML
    private void isEmpty() {
        lblEstado.setText(cola.isEmpty() ? "La cola está vacía" : "La cola NO está vacía");
    }

    private void refreshView() {
        List<String> values = new ArrayList<>();
        cola.forEach(valor -> values.add(String.valueOf(valor)));
        canvas.setValues(values);
        canvas.render();
    }
}
