package org.curso.ayi.jpa.app.repositories.impl;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.entity.Cliente;
import org.curso.ayi.jpa.app.repositories.IClienteRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ClienteRepository implements IClienteRepository {

    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> listar(){
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();

    }
    @Override
    public Cliente getById(Long id){
        return em.find(Cliente.class, id);
    }

    @Override
    public void insertar(@NotNull Cliente cliente){

            em.persist(cliente);

    }
    @Override
    public void guardar(@NotNull Cliente cliente){

        em.persist(cliente);

    }

    @Override
    public void eliminar(Long id){
        Cliente cliente = getById(id);
        em.remove(cliente);
    }


}
