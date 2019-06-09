/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.practicajoined.repositorio;

import ar.com.dag.practicajoined.modelo.Cliente;
import ar.com.dag.practicajoined.modelo.Seguro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author yo
 */
public class ClienteRepositorio extends GenericoRepositorio<Cliente, Long>{

    public ClienteRepositorio(EntityManager em) {
        super(em);
    }
    
    public Cliente getCuentasById(Long id){
        EntityManager em=getEm();
        String query="select c from Cliente c join fetch c.cuentas cus where c.id=:id";
        Query q=em.createQuery(query);
        q.setParameter("id", id);
        Cliente c=(Cliente)q.getSingleResult();
        return c;
    }
    
    public List<Seguro>getSeguro(Cliente cli){
        EntityManager em=getEm();
        String query="from Seguro s where s.cliente=:cli";
        Query q=em.createQuery(query);
        q.setParameter("cli", cli);
        List<Seguro>lista=q.getResultList();
        return lista;
    }
    
}
