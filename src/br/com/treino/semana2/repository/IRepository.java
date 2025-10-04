package br.com.treino.semana2.repository;

import java.util.List;

// Generic Interface
// Tipo T -> O que é? -> classe de modelo exemplo "Diarista".
// Tipo ID -> É o tipo de dado ID da classe'instância' de modelo que identificará o obejto instanciado.
/**
 * Interface genérica para operações básicas de repositório.
 *
 * @param <T>  Tipo da entidade a ser manipulada.
 * @param <ID> Tipo do identificador único da entidade.
 */
public interface IRepository<T,ID> {
    
    List<T> buscarTodos();

    T cadastrar(T model);

    T buscarPorId(ID id);

    boolean excluirPorId(ID id);
}
