package intelCore.Controller;

import intelCore.Modelo.evaluarExpresiones;
import intelCore.Modelo.optenerDatosProcesador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class homeController {
    String cadena = "";
    String sms = "";
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
    private TextArea sufijo;

    @FXML
    private Label gama;

    @FXML
    void empezarOnMuse(MouseEvent event) {
        gama.setText("");
        sufijo.clear();
        generacion.setText("");
        i.setText("");
           cadena = "";
           resultado.clear();
           evaluar =  new evaluarExpresiones();
           datos = new optenerDatosProcesador();
          cadena = entrada.getText();
          if(evaluar.validarDatosDeEntrada(cadena)){
             resultado = datos.datosProcesador(cadena);
              tipoPrefijo();
//              for (String i : resultado) {
//                  System.out.println(i);
//              }
          }else{
              System.out.println("Mal xd");
              sufijo.setText("Texto Incorrecto");
          }

    }

    public void tipoPrefijo(){

        switch (resultado.get(resultado.size()-1)){
            case "T":
                sms = "T: Procesador optimizado para dar prioridad a la potencia";
                asignarVista(sms);
                break;
            case "KF":
                sms = "KF: El procesador no lleva tarjeta gráfica integrada, pero es compatible con Overclock";
                asignarVista(sms);
                break;
            case "K":
                sms = "K: Los procesadores terminados en K no tienen bloqueo de velocidad ni voltaje (se llaman Unlocked). Se pueden overclockear, es decir, aumentar su velocidad de fábrica. Por ejemplo, el i7-6700K. Están pensados para gaming";
                asignarVista(sms);
                break;
            case "F":
                sms = "F: No lleva tarjeta gráfica integrada";
                asignarVista(sms);
                break;
            case "KS":
                sms = "KS: Los procesadores terminados en K no tienen bloqueo de velocidad" +
                        " ni voltaje (se llaman Unlocked). Se pueden overclockear, es decir, " +
                        "ln aumentar su velocidad de fábrica. Por ejemplo, el i7-6700K. Están pensados para gaming";
                asignarVista(sms);
                break;
            case "XE":
                sms = "XE: Extreme. Máximo rendimiento. Son las CPUs más potentes, pero también las más caras";
                asignarVista(sms);
                break;
            case "X":
                sms = "X: Extreme. Máximo rendimiento. Son las CPUs más potentes, pero también las más caras";
                asignarVista(sms);
                break;
            case "TE":
                sms = "TE: Procesador optimizado para dar prioridad a la potencia";
                asignarVista(sms);
                break;
            case "E":
                sms = "E: Es un procesador de escritorio con eficiencia energética, " +
                        "su consumo de energía es menor o igual a 55 Watts hora.";
                asignarVista(sms);
                break;
            case "R":
                sms = "R (Cuarta y Quinta Generación): Procesadores que usan el encapsulado BGA1364";
                asignarVista(sms);
                break;
            case "P":
                sms = "P: Es un procesador mobil con TDP 20-29 Watts";
                asignarVista(sms);
                break;
            case "C":
                sms = "C (Quinta Generación): Procesadores que usan el encapsulado (conector) LG1150";
                asignarVista(sms);
                break;
            case "S":
                sms = "S (Cuarta generación): Optimizado para el rendimiento";
                asignarVista(sms);
                break;
            case "":
                sms = "Sin Sufijo";
                break;
        }

        //System.out.println("Ultimo elemento "+ resultado.get(resultado.size()-1));
    }

    public void asignarVista(String sms){

        sufijo.setText(sms);
        i.setText("i"+resultado.get(1));
        generacion.setText(resultado.get(2)+"TH GEN");
        gama.setText("Gama "+resultado.get(0));
    }

}

