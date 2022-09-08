package org.curso.ayi.jpa.app.repositories;

import org.curso.ayi.jpa.app.entity.Cliente;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IClienteRepository<T>{


    List<Cliente> listar();

    Cliente getById(Long id);

    void insertar(Cliente cliente);

    void guardar(@NotNull Cliente cliente);

    void eliminar(Long id);
}
