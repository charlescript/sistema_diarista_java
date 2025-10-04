package br.com.treino.semana2.repository;

import java.util.List;
import java.util.ArrayList;
import br.com.treino.semana2.models.Cliente;

public class ClienteRepository implements IRepository<Cliente, Long> {

    private List <Cliente> clientes;
    private Long idAtual;

    public ClienteRepository(){
        clientes = new ArrayList<>();
        idAtual = 1L;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clientes;
    }

    @Override
    public Cliente cadastrar(Cliente model) {
       model.setId(idAtual);

       clientes.add(model);
       idAtual++;

       return model;
    }

    @Override
    public Cliente buscarPorId(Long id) {

        for (Cliente cliente : clientes) {
            if(cliente.getId().equals(id)){
                return cliente;
            }
        }

        return null;
    }

    @Override
    public boolean excluirPorId(Long id) {
        
        var clienteEncontrado = buscarPorId(id);

        if(clienteEncontrado != null){
            clientes.remove(clienteEncontrado);
            return true;
        }

        return false;
    }


}
