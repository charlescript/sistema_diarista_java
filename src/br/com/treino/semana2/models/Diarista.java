package br.com.treino.semana2.models;

/**
 * Representa uma diarista, que é um tipo de {@link Pessoa}.
 * 
 * Esta classe herda todos os atributos e comportamentos de Pessoa,
 * podendo ser utilizada para distinguir diaristas de outros tipos de pessoas.
 * 
 * Possui construtores para inicialização com ou sem ID.
 * 
 * @author Charles Rocha
 */
public class Diarista extends Pessoa {
    
    public Diarista() {}

    public Diarista(String nome, String telefone, String cpf, String endereco){
        super(null, nome, telefone, cpf, endereco);
    }

    public Diarista(Long id, String nome, String telefone, String cpf, String endereco){
        super(id, nome, telefone, cpf, endereco);
    }
    
}
