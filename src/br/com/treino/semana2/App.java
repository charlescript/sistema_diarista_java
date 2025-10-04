package br.com.treino.semana2;

import br.com.treino.semana2.funcoes.FuncoesCliente;
import br.com.treino.semana2.models.Cliente;
import br.com.treino.semana2.models.Diarista;
import br.com.treino.semana2.repository.ClienteRepository;
import br.com.treino.semana2.repository.DiaristaRepository;
import br.com.treino.semana2.funcoes.FuncoesDiarista;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento de Diaristas e Clientes.
 * 
 * Esta aplicação permite ao usuário listar, cadastrar, buscar e excluir diaristas e clientes,
 * além de exibir todos os registros cadastrados. O menu principal é exibido em loop até que o
 * usuário escolha sair do sistema.
 * 
 * Funcionalidades disponíveis:
 * <ul>
 *   <li>Listar, cadastrar, buscar e excluir diaristas</li>
 *   <li>Listar, cadastrar, buscar e excluir clientes</li>
 *   <li>Listar todos os diaristas e clientes</li>
 *   <li>Limpar o console</li>
 *   <li>Sair do sistema</li>
 * </ul>
 * 
 * O sistema utiliza repositórios para manipulação dos dados de diaristas e clientes.
 * 
 * @author Charles Rocha
 */
public class App {
    public static void main(String[] args) {
        
        var scanner = new Scanner(System.in);
        var repositoryDiarista = new DiaristaRepository();
        var repositoryCliente = new ClienteRepository();

        var opcao = "q";
        do { 
            exibirMenu();
            System.out.print("Informe a opção desejada: ");
            opcao = scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case "1" -> FuncoesDiarista.listarDiaristas(repositoryDiarista);
                case "2" -> FuncoesDiarista.cadastrarDiarista(scanner, repositoryDiarista);
                case "3" -> FuncoesDiarista.buscarDiarista(scanner, repositoryDiarista);
                case "4" -> FuncoesDiarista.excluirDiarista(scanner, repositoryDiarista);   

                case "5" -> FuncoesCliente.listarClientes(repositoryCliente);
                case "6" -> FuncoesCliente.cadastrarCliente(scanner, repositoryCliente);
                case "7" -> FuncoesCliente.buscarCliente(scanner, repositoryCliente);
                case "8" -> FuncoesCliente.excluirCliente(scanner, repositoryCliente);

                case "9" ->listarDiaristas_Clientes(repositoryDiarista, repositoryCliente);
                
                case "10" -> limparConsole();
                case "q" -> System.out.println("Saindo do sistema.\n");
                default -> System.out.println("Opção inválida");

            }

        } while (!opcao.equals("q"));

        scanner.close();
    }




    private static void exibirMenu(){
        System.out.println("\n1 - Listar Diaristas");
        System.out.println("2 - Cadastrar Diarista");
        System.out.println("3 - Buscar Diarista");
        System.out.println("4 - Excluir Diarista");
        System.out.println("===========================");
        System.out.println("5 - Listar Clientes");
        System.out.println("6 - Cadastrar Clientes");
        System.out.println("7 - Buscar Clientes");
        System.out.println("8 - Excluir Clientes");
        System.out.println("===========================");
        System.out.println("9 - Listar Diaristas e Clientes");
        System.out.println("10 - Limpar Console");   
        System.out.println("Q - Sair do sistema");       
        System.out.println("===========================");
    }

    public static void listarDiaristas_Clientes(DiaristaRepository repositoryDiarista, ClienteRepository repositoryCliente) {
        limparConsole();
        
        var diaristas = repositoryDiarista.buscarTodos();
        var clientes = repositoryCliente.buscarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastradas no momento.");
        } 

        if (diaristas.isEmpty()) {
            System.out.println("Não há diaristas cadastrados no momento");
        }
        
        for( Diarista diarista : diaristas) {
            System.out.println("__________________________________________");
            System.out.println("Diarista: " + diarista.getId() + " - " + diarista.getNome());
        }

        for (Cliente cliente : clientes){
            System.out.println("__________________________________________");
            System.out.println("Cliente: " + cliente.getId() + " - " + cliente.getNome());
        }
    }


    private static void limparConsole(){
        try{
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls", "exit").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear", "exit").inheritIO().start().waitFor();
            }
        } catch(IOException | InterruptedException e) {
            System.out.println("Não foi possível limpar o console: " + e.getMessage());
        }
    }



}