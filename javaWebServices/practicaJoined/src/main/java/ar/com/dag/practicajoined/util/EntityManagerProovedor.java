/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.practicajoined.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author yo
 */
public class EntityManagerProovedor {
    private static EntityManagerProovedor instancia;
    private EntityManagerFactory emf;
    private EntityManager em;

    public EntityManagerProovedor() {
        emf=Persistence.createEntityManagerFactory("pu");
    }
    
    public static EntityManagerProovedor getInstancia(){
        if(instancia==null){
            instancia=new EntityManagerProovedor();
        }
        return instancia;
    }
    
    public EntityManager getEntityManager(){
        em=emf.createEntityManager();
        return em;
    }
    
    public void cerrar(){
        em.close();
        emf.close();
    }
    
}
