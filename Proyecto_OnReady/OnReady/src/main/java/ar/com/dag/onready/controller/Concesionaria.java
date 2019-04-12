/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.onready.controller;

import ar.com.dag.onready.model.Auto;
import ar.com.dag.onready.model.Moto;
import ar.com.dag.onready.model.Vehiculo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Clase Concesionaria la cual manipulara varios objetos de tipo Vehiculo y 
 * consta con los metodos de impresion de los mismos con su informacion
 * @author dagprogramer
 * @version 11/04/2019
 */
public class Concesionaria {
    //atributos de clase
    private List<Vehiculo>vehiculos;

    /**
     * Constructor sin parametros el cual carga en una lista de tipo Vehiculo
     * Se utilizaza la clase Arrays con su metodo asList()
     */
    public Concesionaria() {
        Vehiculo vehiculo1=new Auto(4, "Peugeot","206", "200.000,00");
        Vehiculo vehiculo2=new Moto(125, "Honda", "Titan", "60.000,00");
        Vehiculo vehiculo3=new Auto(5, "Peugeot", "208", "250.000,00");
        Vehiculo vehiculo4=new Moto(160, "Yamaha", "YBR", "80.500,50");
        Vehiculo[]arrayVehiculos={vehiculo1,vehiculo2,vehiculo3,vehiculo4};
        vehiculos=Arrays.asList(arrayVehiculos);
    }
    
    /**
     * metodo de impresion de informacion de lista ordenada y busqueda de 
     * datos requeridos
     */
    public void imprimirInformacion(){
        Vehiculo v=null;
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(vehiculos.get(i));
            if(vehiculos.get(i).getModelo().substring(0, 1).equalsIgnoreCase("y")){
                v=vehiculos.get(i);
            }
        }
        System.out.println("=============================");
        Collections.sort(vehiculos);
        
        Vehiculo masBarato=vehiculos.get(0);
        Vehiculo masCaro=vehiculos.get(vehiculos.size()-1);
        System.out.println("Vehículo más caro: "+masCaro.getMarca()+" "+masCaro.getModelo());
        System.out.println("Vehículo mas barato: "+masBarato.getMarca()+" "+masBarato.getModelo());
        System.out.println("Vehículo que contiene en el modelo la letra 'Y': "+v.getMarca()+" "+v.getModelo()+" "+v.getPrecio());
                
        System.out.println("=============================");
        for (int i = vehiculos.size()-1; i >= 0; i--) {
            Vehiculo vehiculo=vehiculos.get(i);
            System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo());
        }
        
    }
    
}
