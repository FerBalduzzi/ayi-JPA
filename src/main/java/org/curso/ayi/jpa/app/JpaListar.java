package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDb;
import org.curso.ayi.jpa.app.entity.Cliente;

import java.util.List;

public class JpaListar {

    public static void main(String[] args) {

        EntityManager em = JpaUtilDb.getEntityManager();

        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        for (Cliente listaCliente:clientes ){
            System.out.println("Lista CLiente : "+ listaCliente.toString());
        }

        clientes.forEach(System.out::println);

        em.close();


    }
}