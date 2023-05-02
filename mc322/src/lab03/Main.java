package lab03;

import java.util.*;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        Seguradora seguradora = new Seguradora("Capixaba Seguro", "(27)3333-3333", "capixaba.seguros@gmail.com", "Rua Carlos Lindenberg, 999");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seja bem vinde ao sistema de cadastro de clientes e de sinistros (SCCS)");
        System.out.println("Lamentamos o motivo de estar aqui. :(");
        

        System.out.println("CADASTRO DE PESSOA FISICA");

        System.out.print("Para prosseguir, digite o CPF (em uma unica linha): ");
        String cpf1 = scanner.nextLine();

        while(!(ClientePF.validarCPF(cpf1))){
            System.out.print("O cpf eh invalido. Digite novamente: ");
            cpf1 = scanner.nextLine();
        }

        System.out.println("Agora vamos cadastrar um cliente.");

        LocalDate dataLicenca1;
        dataLicenca1 = LocalDate.parse("20/12/2021", formatter);
        LocalDate dataNascimento1;
        dataNascimento1 = LocalDate.parse("10/06/2003", formatter);

        ClientePF cliente1 = new ClientePF("Jasmine", "Av 2", cpf1, "feminino", dataLicenca1, "ensino superior incompleto", dataNascimento1, "media");

        seguradora.cadastrarCliente(cliente1);

        System.out.println("Agora vamos remover este cliente.");

        seguradora.removerCliente("Jasmine");



        System.out.println("Agora vamos cadastrar um cliente do tipo pessoa fisica.");

        System.out.print("Digite o CPF (em uma unica linha): ");
        String cpf2 = scanner.nextLine();

        while(!(ClientePF.validarCPF(cpf2))){
            System.out.print("O cpf eh invalido. Digite novamente: ");
            cpf2 = scanner.nextLine();
        }

        LocalDate dataLicenca2;
        dataLicenca2 = LocalDate.parse("20/12/1995", formatter);
        LocalDate dataNascimento2;
        dataNascimento2 = LocalDate.parse("11/06/1979", formatter);

        ClientePF cliente2 = new ClientePF("Vanessa", "Av 1", cpf2, "feminino", dataLicenca2, "doutorado", dataNascimento2, "alta");

        seguradora.cadastrarCliente(cliente2);


        System.out.println("Agora vamos cadastrar uma pessoa juridica.");

        System.out.print("Para prosseguir, digite o CNPJ (em uma unica linha): ");
        String cnpj = scanner.nextLine();

        while(!(ClientePJ.validarCNPJ(cnpj))){
            System.out.print("Seu cnpj eh invalido. Digite novamente: ");
            cnpj = scanner.nextLine();
        }
        
        LocalDate dataFundacao1;
        dataFundacao1 = LocalDate.parse("20/12/1998", formatter);

        ClientePJ cliente3 = new ClientePJ("MFPU Ltda", "IC 3", cnpj, dataFundacao1);

        seguradora.cadastrarCliente(cliente3);



        System.out.println("Agora vamos adicionar um veiculo ao cliente PF.");

        Veiculo carro1 = new Veiculo("AAA1111", "Honda", "HRV", 2019);

        cliente2.cadastrarVeiculo(carro1);


        System.out.println("Agora vamos adicionar um veiculo ao cliente PJ.");

        Veiculo carro2 = new Veiculo("BBB2222", "Nissan", "Versa", 2012);

        cliente3.cadastrarVeiculo(carro2);



        System.out.println("Agora vamos gerar um sinistro.");
        Sinistro sinistro = new Sinistro("11/11/2011", "Av. 3", seguradora, carro1, cliente2);
        seguradora.gerarSinistro(sinistro);


        System.out.println("Agora vamos listar os clientes do tipo pessoa fisica (PF) da seguradora.");
        seguradora.listarClientes("PF");

        System.out.println("Agora vamos visualizar se existe o sinistro de um cliente");
        if(seguradora.visualizarSinistro("Vanessa") == true){
            System.out.println("O sinistro existe!");
            System.out.println();
        }

        System.out.println("Agora vamos listar os sinistros da seguradora");
        seguradora.listarSinistros();

        Cliente clienteGenerico = new Cliente("Generico", "Av Generica");
        clienteGenerico.cadastrarVeiculo(carro2);


        System.out.println("Agora vamos imprimir os metodos toString() de cada classe.");
        System.out.println("Sinistro:");
        System.out.println(sinistro.toString());
        System.out.println("Cliente:");
        System.out.println(clienteGenerico.toString());
        System.out.println("Cliente PF:");
        System.out.println(cliente2.toString());
        System.out.println("Cliente PJ");
        System.out.println(cliente3.toString());
        System.out.println("Veiculo:");
        System.out.println(carro1.toString());

        scanner.close();
    }
}
