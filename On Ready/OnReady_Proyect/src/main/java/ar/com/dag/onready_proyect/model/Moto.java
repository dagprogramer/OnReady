/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.onready_proyect.model;

/**
 * Clase Moto la cual hereda atributos de la clase Padre Vehiculo y posee propios
 * @version 11/04/2019
 * @author dagprogramer
 */
public class Moto extends Vehiculo{
    //atributos de clase
    private int cilindrada;

    /**
     * Constructor con parametros de entrada para inicio de objeto
     * @param cilindrada parametro de entrada de tipo int
     * @param marca parametro de entrada de tipo String
     * @param modelo parametro de entrada de tipo String
     * @param precio parametro de entrada de tipo int
     */
    public Moto(int cilindrada, String marca, String modelo, String precio) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    /**
     * metodo get para obtener el valor del atributo cilindrada
     * @return cilindrada tipo de dato int
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * metodo set para manipular el valor del atributo cilindrada
     * @param cilindrada parametro de entrada de tipo int
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * metodo toString() sobreescrito para imprimir la informacion de objeto
     * @return tipo de dato String
     */
    @Override
    public String toString() {
        return "Marca: "+getMarca()+" // Modelo: "+getModelo()+" // Cilindrada: "+cilindrada+"c // Precio: $"+getPrecio();
    }
    
}
