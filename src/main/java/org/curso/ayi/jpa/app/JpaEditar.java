package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDb;
import org.curso.ayi.jpa.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;

public class JpaEditar {
    public static void main(String[] args) {
        EntityManager em = JpaUtilDb.getEntityManager();

        try{

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
            Cliente c = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:", c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:", c.getFormaPago());


            em.getTransaction().begin();

            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            c.setFechaCreacion(LocalDate.now());
            System.out.println("Id del cliente: " + c.getId());
            em.merge(c);
            System.out.println("Cliente actualizado " + c.toString());
            em.getTransaction().commit();

        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();

        }finally{
            em.close();
        }
    }
}
