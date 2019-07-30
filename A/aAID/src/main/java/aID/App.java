package aID;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;

import jdk.nashorn.internal.parser.JSONParser;

import com.google.JsonParser;

public class App {

    //variables del objeto
    public int mes;
    public int anno;
    public String empresa;
    public int monto_ventas;
    public int cant_ventas;

    //metodo
    public void App() {
        
    }
    //constructor // la p es de parametro
    App(int mes_p, int anno_p, String empresa_p, int monto_ventas_p, int cant_ventas_p) {
        this.mes = mes_p;
        this.anno = anno_p;
        this.empresa = empresa_p;
        this.monto_ventas = monto_ventas_p;
        this.cant_ventas = cant_ventas_p;
    }


    
    public static void main(String args[]) {
    
        //instanciando clase haciendo un arraylist del tipo de la clase
        //pasando argumentos
        ArrayList<App> milista = new ArrayList<App>();
        milista.add(new App(01,2000,"Chalas Zico",20000000,5450));
        milista.add(new App(02,2001,"Aaioas",10000800,300));
        // milista.add(new A(03,2002,"Aplee",76000000,300));
        // milista.add(new A(04,2003,"Coco Jumbo",43333000,900));
        // milista.add(new A(05,2004,"Ossho",54000000,877));
        // milista.add(new A(06,2005,"Tronquito",7000000,466));
        // milista.add(new A(07,2006,"Gatitos Corp",45000000,656));
        // milista.add(new A(8,2007,"Doggo life",6700000,544));
        // milista.add(new A(9,2008,"Peluquería peluca",3500000,1000));
        // milista.add(new A(10,2009,"Miau guau",5000000,400));
        // milista.add(new A(11,2010,"Microfost",7000000,300));
        // milista.add(new A(12,2020,"Pig brand",600000,500));
     
       
        for (int i = 0; i < 2; i++ ) {
            System.out.print(" Mes: " + milista.get(i).mes + " # Anio: " + milista.get(i).anno + " # Empresa "
                    + milista.get(i).empresa + " # Monto ventas: " + milista.get(i).monto_ventas + " # Cant. ventas: "
                    + milista.get(i).cant_ventas + "\n");
        }
        Gson gson = new Gson();
        JsonParser parse = new JSonParser();
        // gson.toJson(milista);   
        // System.out.println(gson);

    }   

}



