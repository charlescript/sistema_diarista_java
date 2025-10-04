package br.com.treino.semana2.funcoes;

import java.io.IOException;
import java.util.Scanner;
import br.com.treino.semana2.models.Diarista;
import br.com.treino.semana2.repository.DiaristaRepository;

public class FuncoesDiarista {
    
    public static void cadastrarDiarista(Scanner scanner, DiaristaRepository repository) {
        limparConsole();
        System.out.print("Nome: ");
        var nome = scanner.nextLine();

        System.out.print("Telefone: ");
        var telefone = scanner.nextLine();

        System.out.print("CPF: ");
        var cpf = scanner.nextLine();

        System.out.print("Endereço: ");
        var endereco = scanner.nextLine();

        var diarista = new Diarista(nome, telefone, cpf, endereco);
        repository.cadastrar(diarista);
        System.out.println("Diarista cadastrada com sucesso!");
    }



    public static void listarDiaristas(DiaristaRepository repository) {
        limparConsole();
        var diaristas = repository.buscarTodos();
        
        if (diaristas.isEmpty()) {
            System.out.println("Não há diaristas cadastradas no momento.");
        } 

        for (Diarista diarista : diaristas){
            System.out.println("__________________________________________");
            System.out.println(diarista.getId() + " - " + diarista.getNome()+ "\n");
        }
    }
    

    public static void buscarDiarista(Scanner scanner, DiaristaRepository repository) {
        limparConsole();
        System.out.println("Digite o ID do diarista: ");
        var id = scanner.nextLong();
        scanner.nextLine();

        var diarista = repository.buscarPorId(id);

        if( diarista != null){
            System.out.println(diarista.getId() + " - " + diarista.getNome());
        } else {
            System.out.println("Diarista não encontrado(a)!");
        }
    }


    public static void excluirDiarista(Scanner scanner, DiaristaRepository repository){
        limparConsole();
        System.out.print("Digite o ID da diarista para exclusão: ");
        var id = scanner.nextLong();
        scanner.nextLine();

        var diarista = repository.buscarPorId(id);
        var foiExcluido = repository.excluirPorId(id);

        if(foiExcluido){
            var infoExclusao = diarista.getId() + " - " + diarista.getNome();
            System.out.println("\nDiarista: " + infoExclusao + " excluido(a).\n");
        } else {
            System.out.println("Não houve exito na exclusão.");
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
