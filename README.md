# Projeto Semana 2 - Java Básico com Repositórios em Memória

Este projeto foi desenvolvido em **Java** como exercício prático para consolidar conceitos de **orientação a objetos**, **generics** e **persistência em memória**.  
A ideia é simular um pequeno sistema de cadastro de pessoas, diferenciando **Clientes** e **Diaristas**, utilizando repositórios que armazenam dados em memória.

---

## 🎯 Objetivos do Projeto
- Aplicar **conceitos de POO** (herança, abstração, encapsulamento).
- Utilizar **Generics** em interfaces para criar repositórios genéricos.
- Criar repositórios com **persistência em memória** usando `ArrayList`.
- Implementar operações básicas de **CRUD**:
  - Cadastrar
  - Buscar todos
  - Buscar por ID
  - Excluir por ID
- Escrever código limpo, documentado e com boas práticas.

---

## 📂 Estrutura de Pastas

```
C:.
├───.vscode                # Configurações do VS Code
│       settings.json
│
└───src
    └───br
        └───com
            └───treino
                └───semana2
                    │   App.class              # Classe principal compilada
                    │   App.java               # Classe principal que inicia o programa
                    │
                    ├───funcoes                # Pacote de classes auxiliares (futuras funcionalidades)
                    │       FuncoesCliente.java
                    │       FuncoesDiarista.java
                    │
                    ├───models                 # Pacote de modelos (entidades)
                    │       Cliente.java
                    │       Diarista.java
                    │       Pessoa.java
                    │
                    └───repository             # Pacote de repositórios (persistência em memória)
                            ClienteRepository.java
                            DiaristaRepository.java
                            IRepository.java
```

---

## 🧩 Estrutura do Código

### 1. **Interface Genérica - `IRepository<T, ID>`**
Define as operações básicas de um repositório genérico (CRUD):
- `buscarTodos()`
- `cadastrar(T model)`
- `buscarPorId(ID id)`
- `excluirPorId(ID id)`

### 2. **Repositórios em Memória**
- **`ClienteRepository`** → CRUD para clientes.  
- **`DiaristaRepository`** → CRUD para diaristas.  

IDs são gerados automaticamente e os dados ficam salvos apenas em memória.

### 3. **Modelos**
- **`Pessoa`** → classe abstrata base com atributos comuns (`id, nome, telefone, cpf, endereco`).  
- **`Cliente`** → herda de `Pessoa`.  
- **`Diarista`** → herda de `Pessoa`.  

### 4. **App**
Classe principal que serve como ponto de entrada do programa.  
Pode ser utilizada para instanciar repositórios e manipular objetos de **Cliente** e **Diarista**.

---

## 🚀 Próximos Passos
- Adicionar **camada de serviços** (Service Layer) para separar regras de negócio.
- Implementar **tratamento de exceções personalizadas**.
- Criar **testes unitários** com JUnit.
- Evoluir de persistência em memória para **banco de dados** (JDBC, JPA ou Hibernate).
- Futuramente integrar com **Spring Boot** para criar uma API REST.

---

## 👨‍💻 Autor
- **Charles Rocha**  
Projeto desenvolvido para estudo e prática de **Java Intermediário** com foco em **POO** e **persistência em memória**.

---
