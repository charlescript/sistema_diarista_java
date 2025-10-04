package br.com.treino.semana2.models;

/**
 * Representa um cliente, que é uma especialização da classe Pessoa.
 * 
 * Esta classe herda todos os atributos e comportamentos de Pessoa,
 * podendo ser utilizada para distinguir clientes de outros tipos de pessoas no sistema.
 * 
 * Construtores disponíveis:
 * <ul>
 *   <li>Construtor padrão sem argumentos.</li>
 *   <li>Construtor com nome, telefone, cpf e endereço.</li>
 *   <li>Construtor com id, nome, telefone, cpf e endereço.</li>
 * </ul>
 */
public class Cliente extends Pessoa {

    public Cliente() {};

    public Cliente(String nome, String telefone, String cpf, String endereco){
        super(null, nome, telefone, cpf, endereco);
    }

    public Cliente(Long id, String nome, String telefone, String cpf, String endereco){
        super(id, nome, telefone, cpf, endereco);
    }
    
}
