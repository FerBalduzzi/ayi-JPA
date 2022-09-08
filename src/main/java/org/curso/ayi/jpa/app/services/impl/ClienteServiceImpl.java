package org.curso.ayi.jpa.app.services.impl;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.entity.Cliente;
import org.curso.ayi.jpa.app.repositories.IClienteRepository;
import org.curso.ayi.jpa.app.repositories.impl.ClienteRepository;
import org.curso.ayi.jpa.app.services.IClienteService;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements IClienteService {
    private EntityManager em;
    private IClienteRepository<Cliente> iClienteRepository;

    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
        this.iClienteRepository = new ClienteRepository(em);
    }

    public List<Cliente> getAll() {
        return iClienteRepository.listar();
    }

    // Optional determina si hay info en un objeto
    public Optional<Cliente> getById(Long id) {
        Optional<Cliente> clienteById;

        clienteById = Optional.ofNullable(iClienteRepository.getById(id));

        if (clienteById.isPresent()) {
            return clienteById;
        } else {
            return null;
        }
    }

    public void eliminar(Long id) {
        Optional<Cliente> clienteById;

        clienteById = Optional.ofNullable(iClienteRepository.getById(id));
        if (clienteById.isPresent()) {
            try {
                em.getTransaction().begin();
                iClienteRepository.eliminar(id);
                em.getTransaction().commit();

            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em.close();
            }
        }else {
            System.out.println("No se pudo borrar");
        }


    }

    public void insert(Cliente cliente){

            try {
                em.getTransaction().begin();
                iClienteRepository.insertar(cliente);
                em.getTransaction().commit();

            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }finally {
                em.close();
            }


    }

    public void guardar(Cliente cliente){

        if (cliente.getId() > 0) {
            Optional<Cliente> clienteById;

            clienteById = Optional.ofNullable(iClienteRepository.getById(cliente.getId()));

            try {
                em.getTransaction().begin();
                iClienteRepository.guardar(cliente);
                em.getTransaction().commit();

            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em.close();
            }

        }else {
            System.out.println("El cliente a actualizar es invalido");
        }




    }



}


