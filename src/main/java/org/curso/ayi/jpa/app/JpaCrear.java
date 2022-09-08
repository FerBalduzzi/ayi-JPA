package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDb;
import org.curso.ayi.jpa.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;

public class JpaCrear {
    public static void main (String[] args) {
        EntityManager em = JpaUtilDb.getEntityManager();

        try{
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

            em.getTransaction().begin();

            Cliente clienteInsertar = new Cliente();
            clienteInsertar.setNombre(nombre);
            clienteInsertar.setApellido(apellido);
            clienteInsertar.setFormaPago(pago);
            clienteInsertar.setFechaCreacion(LocalDate.now());

            em.persist(clienteInsertar);
            System.out.println(" Cliente guardado satisfactoriamente en DB");

            em.getTransaction().commit();


        }catch (Exception ex){

            em.getTransaction().rollback();
            ex.getMessage();

        }finally{
            em.close();

        }

    }


}
