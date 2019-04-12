/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.onready_proyect.model;

/**
 * Clase Auto la cual hereda atributos de la clase padre Vehiculo.Reescribi
 * mos el metodo toString()para cumplir con los requisitos de impresion.
 * @version 11/04/2019
 * @author dagprogramer
 */
public class Auto extends Vehiculo{
    //atributos de clase
    private int puertas;

    /**
     * Constructor con parametros de entrada para iniciar objeto con atributos
     * @param puertas parametro de entrada de tipo int
     * @param marca parametro de entrada de tipo String
     * @param modelo parametro de entrada de tipo String
     * @param precio parametro de entrada de tipo int
     */
    public Auto(int puertas, String marca, String modelo, String precio) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    /**
     * metodo get que retorna el valor del atributo puertas
     * @return puertas de tipo int
     */
    public int getPuertas() {
        return puertas;
    }

    /**
     * metodo set para modificar el valor del atributo puertas
     * @param puertas parametro de entrada de tipo int
     */
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    /**
     * metodo toString() sobreescrito para imprimir la informacion de objeto
     * @return tipo de dato String con la informacion del objeto
     */
    @Override
    public String toString() {
        return "Marca: "+getMarca()+" // Modelo: "+getModelo()+" // Puertas: "+puertas+" // Precio: $"+getPrecio();
    }

    
    
}
