/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.practicajoined;

import ar.com.dag.practicajoined.modelo.Cliente;
import ar.com.dag.practicajoined.modelo.Cuenta;
import ar.com.dag.practicajoined.modelo.Poliza;
import ar.com.dag.practicajoined.modelo.Seguro;
import ar.com.dag.practicajoined.repositorio.ClienteRepositorio;
import ar.com.dag.practicajoined.util.EntityManagerProovedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yo
 */
public class Main {
    public static void main(String[] args) {
        Cuenta cuenta1=new Cuenta(15000.0F);
        Cuenta cuenta2=new Cuenta(25000.0F);
        List<Cuenta>cuentasDiego=new ArrayList<>();
        cuentasDiego.add(cuenta1);
        cuentasDiego.add(cuenta2);
        
        Seguro seguro1=new Seguro(13000.0F);
        seguro1.setPoliza(new Poliza("Poliza seguro vida"));
        List<Seguro>segurosDiego=new ArrayList<>();
        segurosDiego.add(seguro1);
        
        Cliente clienteUno=new Cliente("diego", "guzman");
        clienteUno.setCuentas(cuentasDiego);
        clienteUno.setSeguros(segurosDiego);
        
        Cuenta cuentaUno=new Cuenta(18000.0F);
        List<Cuenta>cuentasPablo=new ArrayList<>();
        cuentasPablo.add(cuentaUno);
        
        Seguro seguroUno=new Seguro(15000.0F);
        seguroUno.setPoliza(new Poliza("Poliza seguro contra robos"));
        
        Seguro seguroDos=new Seguro(25000.0F);
        seguroDos.setPoliza(new Poliza("Poliza seguro vivienda"));
        List<Seguro>segurosPablo=new ArrayList<>();
        segurosPablo.add(seguroUno);
        segurosPablo.add(seguroDos);
        
        Cliente clienteDos=new Cliente("pablo", "guzman");
        clienteDos.setCuentas(cuentasPablo);
        clienteDos.setSeguros(segurosPablo);
        
        ClienteRepositorio repositorio=new ClienteRepositorio(EntityManagerProovedor.getInstancia().getEntityManager());
        repositorio.persiste(clienteUno);
        repositorio.persiste(clienteDos);
        
        System.out.println("Los clientes ingresados en la base de datos son");
        repositorio.getAll().forEach(System.out::println);
        System.out.println();
        
        System.out.println("Datos de cuentas del Cliente 1");
        Cliente c=repositorio.getCuentasById(1L);
        imprimirCuentas(c);
        System.out.println();
        
        System.out.println("Datos de seguros del Cliente 2");
        Cliente cli=new Cliente();
        cli.setId(2L);
        List<Seguro>lista=repositorio.getSeguro(cli);
        System.out.println("El cliente "+cli.getNombre()+" "+cli.getApellido()+",posee seguros:");
        imprimirSeguros(lista);
        
        EntityManagerProovedor.getInstancia().cerrar();
        
    }

    private static void imprimirCuentas(Cliente c) {
        System.out.println("El cliente: "+c.getNombre()+" "+c.getApellido()+",posee cuentas:");
        for(Cuenta cuenta:c.getCuentas()){
            System.out.println(cuenta.toString());
        }
    }

    private static void imprimirSeguros(List<Seguro> lista) {
        for (Seguro lista1 : lista) {
            System.out.println(lista1.toString());
        }
    }
}
