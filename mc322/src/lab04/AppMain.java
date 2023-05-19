package lab04;

import java.util.*;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;

public class AppMain {
    public static void main(String[] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);

        Seguradora seguradora = new Seguradora("Capixaba Seguro", "(27)3333-3333", "capixaba.seguros@gmail.com", "Rua Carlos Lindenberg, 999");

        Veiculo carro1 = new Veiculo("AAA1111", "Honda", "HRV", 2019);

        Veiculo carro2 = new Veiculo("BBB2222", "Nissan", "Versa", 2012);

        LocalDate dataLicenca1 = LocalDate.parse("20/12/2021", formatter);
        LocalDate dataNascimento1 = LocalDate.parse("10/06/2003", formatter);
        ClientePF cliente1 = new ClientePF("Jasmine", "Av 2", "343.447.100-61", "feminino", dataLicenca1, "ensino superior incompleto", dataNascimento1, "media");

        LocalDate dataFundacao1 = LocalDate.parse("20/12/1998", formatter);
        ClientePJ cliente2 = new ClientePJ("MFPU Ltda", "IC 3", "77.155.520/0001-06", dataFundacao1);

        System.out.println("Agora vamos adicionar um veiculo ao cliente PF.");
        cliente1.cadastrarVeiculo(carro1);
        System.out.println("Agora vamos adicionar um veiculo ao cliente PJ.");
        cliente2.cadastrarVeiculo(carro2);

        System.out.println("Agora vamos cadastrar esses clientes na seguradora.");
        seguradora.cadastrarCliente(cliente1);
        seguradora.cadastrarCliente(cliente2);


        System.out.println("Agora vamos gerar dois sinistros.");

        LocalDate dataSinistro1 = LocalDate.parse("20/12/2015", formatter);
        Sinistro sinistro1 = new Sinistro(dataSinistro1, "Av 3", seguradora, carro1, cliente1);
        seguradora.gerarSinistro(sinistro1);

        LocalDate dataSinistro2 = LocalDate.parse("23/11/2017", formatter);
        Sinistro sinistro2 = new Sinistro(dataSinistro2, "Av 2", seguradora, carro2, cliente2);
        seguradora.gerarSinistro(sinistro2);

        System.out.println("Agora vamos listar os clientes do tipo pessoa fisica (PF) da seguradora.");
        seguradora.listarClientes("PF");
        System.out.println("Agora vamos listar os clientes do tipo pessoa fisica (PJ) da seguradora.");
        seguradora.listarClientes("PJ");

        System.out.println("Agora vamos listar os sinistros da seguradora");
        seguradora.listarSinistros();

        System.out.println("Agora vamos visualizar se existe o sinistro de um cliente");
        if(seguradora.visualizarSinistro("Jasmine") == true){
            System.out.println("O sinistro existe!");
            System.out.println();
        }

        System.out.println("Agora vamos calcular a receita da seguradora e imprimir.");
        System.out.println(seguradora.calcularReceita());

        System.out.println("Agora vamos atualizar o atributo valorSeguro de cada cliente cadastrado.");
        cliente1.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente1));
        cliente2.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente2));


        boolean continuar = true;

        while(continuar){
            // impressao do menu de opcoes
            System.out.println("BEM VINDE AO MENU DE OPCOES:");
            System.out.println("Selecione uma opcao.");
            for(int i = 0; i < MenuOperacoes.values().length; i++){
                System.out.println((i + 1) + " - " + MenuOperacoes.values()[i]);
            }
            System.out.println("0 - SAIR");

            int opcao = scanner.nextInt();

            if(opcao == 0){
                continuar = false;
            }

            else if(opcao >= 1 && opcao <= MenuOperacoes.values().length){
                MenuOperacoes operacaoSelecionada = MenuOperacoes.values()[opcao - 1];
                operacaoSelecionada.executar(scanner);
            }

            else{
                System.out.println("Operacao invalida. Digite novamente.");
            }
        }

        scanner.close();
    }
}
