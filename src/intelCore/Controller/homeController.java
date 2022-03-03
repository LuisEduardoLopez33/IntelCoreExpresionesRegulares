package intelCore.Controller;

import intelCore.Modelo.evaluarExpresiones;
import intelCore.Modelo.optenerDatosProcesador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class homeController {
    String cadena = "";
    evaluarExpresiones evaluar;
    optenerDatosProcesador datos;
    ObservableList<String> resultado = FXCollections.observableArrayList();
    @FXML
    private TextField entrada;

    @FXML
    private Label i;

    @FXML

    private Label generacion;

    @FXML
    void empezarOnMuse(MouseEvent event) {
           cadena = "";
           resultado.clear();
           evaluar =  new evaluarExpresiones();
           datos = new optenerDatosProcesador();
          cadena = entrada.getText();
          if(evaluar.validarDatosDeEntrada(cadena)){
             resultado = datos.datosProcesador(cadena);
          }else{

          }
        for (String i : resultado) {
            System.out.println(i);
        }
    }

}

