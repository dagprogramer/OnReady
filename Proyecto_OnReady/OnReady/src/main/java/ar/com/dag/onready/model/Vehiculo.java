/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.onready.model;

/**
 *Clase abstracta Vehiculo la cual contiene los atributos en comun que tienen
 * las clases que heredan de la misma.Asi mismo implementamos la interfaz
 * Comparable para ordenar los objetos reescribiendo el metodo compareTo().
 * @version 11/04/2019
 * @author dagprogramer
 */
public abstract class Vehiculo implements Comparable<Vehiculo>{
    //atributos de clase
    private String marca;
    private String modelo;
    private String precio;
    
    /**
     * Constructor con parametros de entrada que inicia el objeto
     * @param marca parametro de entrada de tipo String
     * @param modelo parametro de entrada de tipo String
     * @param precio parametro de entrada de tipo int
     */
    public Vehiculo(String marca, String modelo, String precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    /**
     * metodo get para obtener el valor del atributo marca
     * @return marca de tipo String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * metodo set para cambiar de valor al atributo marca
     * @param marca parametro de entrada de tipo String
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * metodo get para obtener el valor del atributo modelo
     * @return marca de tipo String
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * metodo set para cambiar de valor al atributo modelo
     * @param modelo parametro de entrada de tipo String
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * metodo get para obtener el valor del atributo precio
     * @return precio de tipo double
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * metodo set para cambiar de valor al atributo precio
     * @param precio parametro de entrada de tipo double
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * metodo de ordenamiento de objetos de tipo Vehiculo por precio
     * @param o parametro entrada de tipo Vehiculo
     * @return tipo de dato int
     */
    @Override
    public int compareTo(Vehiculo o) {
        int retorno=0;
        String[]args1=this.precio.split("\\.");
        String[]args2=o.getPrecio().split("\\.");
        if(Integer.parseInt(args1[0])<Integer.parseInt(args2[0])){
            retorno=-1;
        }else if(Integer.parseInt(args1[0])>Integer.parseInt(args2[0])){
            retorno=1;
        }
        return retorno;
    }
    
}
