/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.practicajoined.repositorio;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author yo
 */
public class GenericoRepositorio<E,PK extends Serializable> {
    private EntityManager em;

    public GenericoRepositorio(EntityManager em) {
        this.em = em;
    }
    
    public Class<E>getTipo(){
        ParameterizedType supper=(ParameterizedType)getClass().getGenericSuperclass();
        Type[]args=supper.getActualTypeArguments();
        return (Class<E>)args[0];
    }
    
    public E getById(PK id){
        E e=em.find(getTipo(), id);
        return e;
    }
    
    public E saveOrUpdate(E objeto){
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        E e=em.merge(objeto);
        tx.commit();
        return e;
    }
    
    public void persiste(E e){
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.persist(e);
        tx.commit();
    }
    
    public void remove(E e){
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.remove(e);
        tx.commit();
    }
    
    public List<E>getAll(){
        String query="from "+getTipo().getName();
        Query q=em.createQuery(query);
        List<E>lista=q.getResultList();
        return lista;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
