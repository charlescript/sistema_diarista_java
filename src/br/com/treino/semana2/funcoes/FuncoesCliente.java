package br.com.treino.semana2.funcoes;

import java.io.IOException;
import java.util.Scanner;

import br.com.treino.semana2.models.Cliente;
import br.com.treino.semana2.repository.ClienteRepository;

public class FuncoesCliente {

        public static void cadastrarCliente(Scanner scanner, ClienteRepository repositoryCliente) {
        limparConsole();
        System.out.print("Nome: ");
        var nome = scanner.nextLine();

        System.out.print("Telefone: ");
        var telefone = scanner.nextLine();

        System.out.print("CPF: ");
        var cpf = scanner.nextLine();

        System.out.print("Endereço: ");
        var endereco = scanner.nextLine();

        var cliente = new Cliente(nome, telefone, cpf, endereco);
        repositoryCliente.cadastrar(cliente);
        System.out.println("Diarista cadastrada com sucesso!");
    }



    public static void listarClientes(ClienteRepository repositoryCliente) {
        limparConsole();
        var clientes = repositoryCliente.buscarTodos();
        
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastradas no momento.");
        } 

        for (Cliente cliente : clientes){
            System.out.println("__________________________________________");
            System.out.println(cliente.getId() + " - " + cliente.getNome()+ "\n");
        }
    }
    

    public static void buscarCliente(Scanner scanner, ClienteRepository repositoryCliente) {
        limparConsole();
        System.out.println("Digite o ID do Cliente: ");
        var id = scanner.nextLong();
        scanner.nextLine();

        var cliente = repositoryCliente.buscarPorId(id);

        if( cliente != null){
            System.out.println(cliente.getId() + " - " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado(a)!");
        }
    }


    public static void excluirCliente(Scanner scanner, ClienteRepository repositoryCliente){
        limparConsole();
        System.out.print("Digite o ID do Cliente para exclusão: ");
        var id = scanner.nextLong();
        scanner.nextLine();

        var cliente = repositoryCliente.buscarPorId(id);
        var foiExcluido = repositoryCliente.excluirPorId(id);

        if(foiExcluido){
            var infoExclusao = cliente.getId() + " - " + cliente.getNome();
            System.out.println("\nCliente: " + infoExclusao + " excluido(a).\n");
        } else {
            System.out.println("Não houve exito na exclusão do cliente.");
        }
    }


    private static void limparConsole(){
        try{
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch(IOException | InterruptedException e) {
            System.out.println("Não foi possível limpar o console: " + e.getMessage());
        }
    }


}
