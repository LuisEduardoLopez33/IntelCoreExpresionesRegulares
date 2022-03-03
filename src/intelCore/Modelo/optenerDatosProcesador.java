package intelCore.Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class optenerDatosProcesador {
    List<String> list = new ArrayList<String>();
    List<String> listApoyo = new ArrayList<String>();
    ObservableList<String> resultado = FXCollections.observableArrayList();
    static String cadenaRepuesto = "";
    static private String numeros = "";
    static private String letras = "";
    private int numeroFormateado = 0;


   public ObservableList datosProcesador(String cadena){
       resultado.clear();
       list.clear();
       listApoyo.clear();
       cadenaRepuesto = "";
       numeros = "";
       letras = "";

       for (int i=0; i<cadena.length(); i++){
           list.add(cadena.substring(i,i+1));
       }
       cadenaRepuesto = cadena;
       gamaProcesador();
       generacionProcesador();
       sufijoProcesador();
       return resultado;
   }

   public void gamaProcesador(){
       String gama = "";
        for(int i=0; i< list.size(); i ++ ){
            if(list.get(i).equals("i")){
                gama = list.get(i+1);
                break;
            }
        }
        switch (gama){
            case "3": resultado.add("baja"); break;
            case "5": resultado.add("media"); break;
            case "7": resultado.add("alta") ; break;
            case "9": resultado.add("premium"); break;
        }
        resultado.add(gama);
   }

   public void generacionProcesador(){
       // buscamos los numeros dentro de la cadena de entrada
       for(short indice = 0; indice < cadenaRepuesto.length(); indice++){
           char caracter = cadenaRepuesto.charAt(indice);
           if(isNumeric(caracter))
           {
               numeros += caracter;
           }else
           {
               letras += caracter;
           }
       }
       // convertimos el string en un array y mandamos la generacion del procesador
       for (int i=0; i<numeros.length(); i++){
           listApoyo.add(numeros.substring(i,i+1));
       }
       if (listApoyo.size()>5){
           resultado.add(listApoyo.get(1)+listApoyo.get(2));
       }else{
           resultado.add(listApoyo.get(1));
       }
   }

   public void sufijoProcesador(){
       // limpiamos la lista de apoyos que contenia los numeros para ahora meter la letras
       listApoyo.clear();
       for (int i=0; i<letras.length(); i++){
           listApoyo.add(letras.substring(i,i+1));
       }
       try {
           if(listApoyo.size() > 3){
               resultado.add(listApoyo.get(2)+listApoyo.get(3));
           }else{
               resultado.add(listApoyo.get(2));
           }
       }catch(Exception e){
           System.out.println("sin prefijo");
           resultado.add("");
       }


   }
    private static boolean isNumeric(char caracter){
        try {
            Integer.parseInt(String.valueOf(caracter));
            return true;
        } catch (NumberFormatException ex){
            return false;
        }

    }


}
