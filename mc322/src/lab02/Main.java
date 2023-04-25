package lab02;

import java.util.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seja bem vinde ao sistema de cadastro de clientes e de sinistros (SCCS)");
        System.out.println("Lamentamos o motivo de estar aqui. :(");
        System.out.print("Para prosseguir, digite seu CPF (em uma unica linha): ");
        String cpf = scanner.nextLine();

        while(!(Cliente.validarCPF(cpf))){
            System.out.print("Seu cpf eh invalido. Digite novamente: ");
            cpf = scanner.nextLine();
        }

        System.out.println("Perfeito! Agora digite seus outros dados.");
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNascimentoCliente = scanner.nextLine();
        System.out.print("Idade: ");
        String idadeCliente = scanner.nextLine();
        System.out.print("Endereco: ");
        String enderecoCliente = scanner.nextLine();


        Cliente cliente = new Cliente(nomeCliente, cpf, dataNascimentoCliente, idadeCliente, enderecoCliente);
        int id_sinistro = Sinistro.generateId();

        System.out.println("Certo, " + cliente.getNome() + ". O id do seu sinistro eh: " + id_sinistro);
        System.out.print("Digite o local do acidente: ");
        String enderecoSinistro = scanner.nextLine();

        String data = java.time.LocalDate.now().toString();
        Sinistro sinistro = new Sinistro(id_sinistro, data, enderecoSinistro);

        System.out.println("Seguem as informacoes a respeito de seu sinistro cadastrado:");
        System.out.println("ID: " + sinistro.getId());
        System.out.println("Data: " + data);
        System.out.println("Endereco: " + sinistro.getEndereco());

        System.out.println();

        Seguradora seguradora = new Seguradora("Capixaba Seguro", "(27)3333-3333", "capixaba.seguros@gmail.com", "Rua Carlos Lindenberg, 999");
        Veiculo veiculo = new Veiculo("BMW1A13", "BMW", "320i");

        System.out.println("Seguem as informacoes a respeito de seu veiculo e da seguradora cadastrados:");

        System.out.println("Seguradora: " + seguradora.getNome());
        System.out.println("Telefone da Seguradora: " + seguradora.getTelefone());
        System.out.println("E-mail da Seguradora: " + seguradora.getEmail());
        System.out.println("Endereco da Seguradora: " + seguradora.getEndereco());

        System.out.println();

        System.out.println("Placa do veiculo: " + veiculo.getPlaca());
        System.out.println("Marca do veiculo: " + veiculo.getMarca());
        System.out.println("Modelo do veiculo: " + veiculo.getModelo());

        scanner.close();
    }
}
