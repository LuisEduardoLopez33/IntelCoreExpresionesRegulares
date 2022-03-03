package intelCore.Controller;

import intelCore.Modelo.evaluarExpresiones;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class homeController {
     evaluarExpresiones evaluar = new evaluarExpresiones();
    @FXML
    private TextField entrada;

    @FXML
    void empezarOnMuse(MouseEvent event) {
           String cadena = "";
          cadena = entrada.getText();
          if(evaluar.validarDatosDeEntrada(cadena)){
              System.out.println("hola Luis esta correcto mi pa:)");
          }else{
              System.out.println("no mi loco, no es correcta la entrada");
          }
    }

}
