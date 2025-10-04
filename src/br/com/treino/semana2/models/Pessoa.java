package br.com.treino.semana2.models;

/**
 * Classe abstrata que representa uma pessoa com informações básicas.
 * 
 * <p>
 * Esta classe serve como base para outras classes que representam tipos específicos de pessoas.
 * Contém atributos comuns como id, nome, telefone, CPF e endereço, além de métodos de acesso
 * (getters e setters), métodos para comparação (equals e hashCode) e uma representação em string (toString).
 * </p>
 * 
 * <p>
 * Os campos desta classe são:
 * <ul>
 *   <li>id: Identificador único da pessoa.</li>
 *   <li>nome: Nome completo da pessoa.</li>
 *   <li>telefone: Número de telefone da pessoa.</li>
 *   <li>cpf: Cadastro de Pessoa Física (CPF) da pessoa.</li>
 *   <li>endereco: Endereço residencial da pessoa.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Esta classe deve ser estendida por outras classes que representam tipos específicos de pessoas.
 * </p>
 * 
 * @author Charles Rocha
 * @since 1.0
 */
public abstract class Pessoa {
    
    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String endereco;

    public Pessoa() {   }

    public Pessoa(Long id, String nome, String telefone, String cpf, String endereco){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    //////////////////////////////
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    //////////////////////////////
    
    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    //////////////////////////////
    
    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    //////////////////////////////
    
    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        return true;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pessoa{");
        sb.append("id= ").append(id);
        sb.append(", nome= ").append(nome);
        sb.append(", telefone= ").append(telefone);
        sb.append(", cpf= ").append(cpf);
        sb.append(", endereco= ").append(endereco);
        sb.append('}');
        return sb.toString();
    }
    
    

    // @Override
    // public String toString(){
    //     return "Pessoa [id = " + id + ", nome = " + nome + ", telefone = " + telefone + ", cpf = " + cpf + ", endereco = " + endereco + "]";
    // }
    
}
