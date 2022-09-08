package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDb;
import org.curso.ayi.jpa.app.entity.Cliente;

import java.util.Scanner;

public class JpaEliminar {
    public static void main(String[] args) {
        EntityManager em = JpaUtilDb.getEntityManager();

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar: ");
        Long id = s.nextLong();

        try{
            Cliente clienteEliminar = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(clienteEliminar);
            em.getTransaction().commit();

        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();

        }finally{
            em.close();
        }
    }
}

