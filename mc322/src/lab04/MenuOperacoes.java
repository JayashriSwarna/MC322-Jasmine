package lab04;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;

public enum MenuOperacoes{
    
    CADASTROS(1){
        public void executar(Scanner scanner){
            System.out.println("Voce selecionou a opcao 1: cadastros.");
            System.out.println("Selecione uma opcao para continuar.");
            System.out.println("1 - Cadastrar Cliente PF/PJ");
            System.out.println("2 - Cadastrar Veiculo");
            System.out.println("3 - Cadastrar Seguradora");
            System.out.println("0 - Voltar");


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            boolean achou_seguradora;
            boolean opcao_valida = false;

            while(!opcao_valida){
                switch(opcao){
                    case 1:
                        // cadastrar cliente na seguradora
                        achou_seguradora = false;
                        
                        while(!achou_seguradora){
                            System.out.print("Digite o nome da seguradora da qual deseja listar os clientes: ");
                            String nome_seguradora = scanner.nextLine();
                            String nome_cliente = "", endereco_cliente, tipo_cliente;
                            String cpf_cliente = "", genero_cliente, data_licenca_cliente_str, educacao_cliente, data_nascimento_cliente_str, classe_economica_cliente;
                            String cnpj_cliente = "", data_fundacao_cliente_str;
                            LocalDate data_licenca_cliente, data_nascimento_cliente, data_fundacao_cliente;
                            
                            // buscar seguradora
                            for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                                if(seguradora_na_lista.getNome().equals(nome_seguradora)){
                                    achou_seguradora = true;
                                    
                                    // validar nome
                                    boolean nome_valido = false;
                                    while(!nome_valido){
                                        System.out.print("Digite o nome do cliente que deseja adicionar: ");
                                        nome_cliente = scanner.nextLine();
                                        if(Validacao.validarNome(nome_cliente)){
                                            nome_valido = true;
                                        }
                                        else{
                                            System.out.println("Nome invalido. Tente novamente.");
                                        }
                                    }

                                    System.out.print("Digite o endereco do cliente que deseja adicionar: ");
                                    endereco_cliente = scanner.nextLine();

                                    System.out.print("Digite o tipo de cliente que deseja adicionar ('PF' ou 'PJ'): ");
                                    tipo_cliente = scanner.nextLine();

                                    // validar cpf
                                    if(tipo_cliente.equals("PF")){
                                        boolean cpf_valido = false;
                                        while(!cpf_valido){
                                            System.out.print("Digite o CPF do cliente que deseja adicionar: ");
                                            cpf_cliente = scanner.nextLine();

                                            if(Validacao.validarCPF(cpf_cliente)){
                                                cpf_valido = true;
                                            }
                                            else{
                                                System.out.println("CPF invalido. Tente novamente.");
                                            }
                                        }

                                        System.out.print("Digite o genero do cliente que deseja adicionar: ");
                                        genero_cliente = scanner.nextLine();
                                        System.out.print("Digite a data de licenca do cliente que deseja adicionar: ");
                                        data_licenca_cliente_str = scanner.nextLine();
                                        data_licenca_cliente = LocalDate.parse(data_licenca_cliente_str, formatter);
                                        System.out.print("Digite a educacao do cliente que deseja adicionar: ");
                                        educacao_cliente = scanner.nextLine();
                                        System.out.print("Digite a data de nascimento do cliente que deseja adicionar: ");
                                        data_nascimento_cliente_str = scanner.nextLine();
                                        data_nascimento_cliente = LocalDate.parse(data_nascimento_cliente_str, formatter);
                                        System.out.print("Digite a classe economica do cliente que deseja adicionar: ");
                                        classe_economica_cliente = scanner.nextLine();

                                        ClientePF cliente_adicionar = new ClientePF(nome_cliente, endereco_cliente, cpf_cliente, genero_cliente, data_licenca_cliente, educacao_cliente, data_nascimento_cliente, classe_economica_cliente);
                                        
                                        seguradora_na_lista.cadastrarCliente(cliente_adicionar);
                                        
                                    }

                                    // validar cnpj
                                    else if (tipo_cliente.equals("PJ")){
                                        boolean cnpj_valido = false;
                                        while(!cnpj_valido){
                                            System.out.print("Digite o CNPJ do cliente que deseja adicionar: ");
                                            cnpj_cliente = scanner.nextLine();
                                            if(Validacao.validarCNPJ(cnpj_cliente)){
                                                cnpj_valido = true;
                                            }
                                            else{
                                                System.out.println("CNPJ invalido. Tente novamente.");
                                            }
                                        }

                                        System.out.print("Digite a data de fundacao do cliente/empresa que deseja adicionar: ");
                                        data_fundacao_cliente_str = scanner.nextLine();
                                        data_fundacao_cliente = LocalDate.parse(data_fundacao_cliente_str, formatter);

                                        ClientePJ cliente_adicionar = new ClientePJ(nome_cliente, endereco_cliente, cnpj_cliente, data_fundacao_cliente);
                                        seguradora_na_lista.cadastrarCliente(cliente_adicionar);
                                    }
                                }
                            }
                            if(!achou_seguradora){
                                System.out.println("Seguradora invalida. Tente novamente.");
                            }
                        }

                        opcao_valida = true;
                        break;

                    case 2:
                        // cadastrar veiculo na seguradora
                        achou_seguradora = false;
                        
                        while(!achou_seguradora){
                            System.out.print("Digite o nome da seguradora onde deseja cadastrar o veiculo: ");
                            String nome_seguradora = scanner.nextLine();
                            String tipo_cliente, identificador = "";
                            String placa_veiculo, marca_veiculo, modelo_veiculo;
                            int ano_fabricacao_veiculo;

                            for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                                if(seguradora_na_lista.getNome().equals(nome_seguradora)){
                                    achou_seguradora = true;

                                    // aqui
                                    System.out.print("Digite a placa do veiculo que deseja cadastrar: ");
                                    placa_veiculo = scanner.nextLine();
                                    System.out.print("Digite a marca do veiculo que deseja cadastrar: ");
                                    marca_veiculo = scanner.nextLine();
                                    System.out.print("Digite o modelo do veiculo que deseja cadastrar: ");
                                    modelo_veiculo = scanner.nextLine();
                                    System.out.print("Digite o ano de fabricacao do veiculo que deseja cadastrar: ");
                                    ano_fabricacao_veiculo = scanner.nextInt();
                                    scanner.nextLine();

                                    Veiculo veiculo_cadastrar = new Veiculo(placa_veiculo, marca_veiculo, modelo_veiculo, ano_fabricacao_veiculo);

                                    System.out.print("Digite o tipo do cliente para o qual deseja cadastrar o veiculo ('PF' ou 'PJ'): ");
                                    tipo_cliente = scanner.nextLine();

                                    if(tipo_cliente.equals("PF")){
                                        System.out.print("Digite o CPF do cliente para o qual deseja cadastrar o veiculo: ");
                                        identificador = scanner.nextLine();
                                    }
                                    else if(tipo_cliente.equals("PJ")){
                                        System.out.print("Digite o CNPJ do cliente para o qual deseja cadastrar o veiculo: ");
                                        identificador = scanner.nextLine();
                                    }

                                    for(Cliente cliente_na_lista : seguradora_na_lista.getListaClientes()){
                                        if(cliente_na_lista instanceof ClientePF && tipo_cliente.equals("PF")){
                                            ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                                            if(cliente_pf_na_lista.getCpf().equals(identificador)){
                                                cliente_pf_na_lista.cadastrarVeiculo(veiculo_cadastrar);
                                            }
                                        }
                                        else if(cliente_na_lista instanceof ClientePJ && tipo_cliente.equals("PJ")){
                                            ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                                            if(cliente_pj_na_lista.getCnpj().equals(identificador)){
                                                cliente_pj_na_lista.cadastrarVeiculo(veiculo_cadastrar);
                                            }
                                        }
                                    }
                                }
                            }
                            if(!achou_seguradora){
                                System.out.println("Seguradora invalida. Tente novamente.");
                            }
                        }

                        opcao_valida = true;
                        break;

                    case 3:
                        // cadastrar seguradora na lista de seguradoras

                        System.out.print("Digite o nome da seguradora que deseja cadastrar: ");
                        String nome_seguradora = scanner.nextLine();
                        System.out.print("Digite o telefone da seguradora que deseja cadastrar: ");
                        String telefone_seguradora = scanner.nextLine();
                        System.out.print("Digite o email da seguradora que deseja cadastrar: ");
                        String email_seguradora = scanner.nextLine();
                        System.out.print("Digite o endereco da seguradora que deseja cadastrar: ");
                        String endereco_seguradora = scanner.nextLine();

                        Seguradora nova_seguradora = new Seguradora(nome_seguradora, telefone_seguradora, email_seguradora, endereco_seguradora);
                        this.getListaSeguradoras().add(nova_seguradora);

                        opcao_valida = true;
                        break;
                        
                    case 0:
                        opcao_valida = true;
                        break;

                    default:
                        System.out.println("Tipo invalido, tente novamente.");
                }
            }
        }
    },

    LISTAR(2){
        public void executar(Scanner scanner){
            System.out.println("Voce selecionou a opcao 2: listar.");
            System.out.println("Selecione uma opcao para continuar.");
            System.out.println("1 - Listar cliente (PF/PJ) por seguradora");
            System.out.println("2 - Listar sinistros por seguradora");
            System.out.println("3 - Listar sinistro por cliente");
            System.out.println("4 - Listar veiculo por cliente");
            System.out.println("5 - Listar veiculo por seguradora");
            System.out.println("0 - Voltar");
            String nome_seguradora;
            String tipoCliente, tipo_cliente;
            boolean opcao_valida = false;

            while(!opcao_valida){
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao){
                    case 1:
                        // listar cliente por seguradora
                        System.out.print("Digite o nome da seguradora da qual deseja listar os clientes: ");
                        nome_seguradora = scanner.nextLine();
                        System.out.print("Digite o tipo de cliente que deseja listar: ");
                        tipo_cliente = scanner.nextLine();
                        
                        for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){   // tive que acessar get
                            if(seguradora_na_lista.getNome().equals(nome_seguradora)){
                                seguradora_na_lista.listarClientes(tipo_cliente);
                            }
                        } 
                        opcao_valida = true;
                        break;

                    case 2:
                        // listar sinistros por seguradora
                        System.out.print("Digite o nome da seguradora da qual deseja listar os clientes: ");
                        nome_seguradora = scanner.nextLine();

                        for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){   // tive que acessar get
                            if(seguradora_na_lista.getNome().equals(nome_seguradora)){
                                seguradora_na_lista.listarSinistros();
                            }
                        } 
                        opcao_valida = true;
                        break;

                    case 3:
                        // listar sinistros por cliente
                        boolean tipoValido = false;

                        while(!tipoValido){
                            System.out.print("Digite o tipo do cliente do qual se deseja listar os sinistos ('PF' ou 'PJ')");
                            tipoCliente = scanner.nextLine();

                            if(tipoCliente.equals("PF")){
                                System.out.print("Digite o CPF do cliente do qual se deseja listar os sinistos: ");
                                String cpfCliente = scanner.nextLine();

                                // percorrer lista de sinistros de cada seguradora, acessar cliente e comparar o cpf/cnpj.
                                
                                for(Seguradora seguradora : this.getListaSeguradoras()){
                                    for(Sinistro sinistro_na_lista : seguradora.getListaSinistros()){
                                        if(sinistro_na_lista.getCliente() instanceof ClientePF){
                                            ClientePF cliente_pf_na_lista = (ClientePF) sinistro_na_lista.getCliente();
                                            if(cliente_pf_na_lista.getCpf().equals(cpfCliente)){
                                                System.out.println(sinistro_na_lista.toString());
                                            }
                                        }
                                    }
                                }
                                tipoValido = true;
                            }

                            else if(tipoCliente.equals("PJ")){
                                System.out.print("Digite o CNPJ do cliente do qual se deseja listar os sinistos: ");
                                String cnpjCliente = scanner.nextLine();

                                // percorrer lista de sinistros de cada seguradora, acessar cliente e comparar o cpf/cnpj.
                                
                                for(Seguradora seguradora : this.getListaSeguradoras()){
                                    for(Sinistro sinistro_na_lista : seguradora.getListaSinistros()){
                                        if(sinistro_na_lista.getCliente() instanceof ClientePJ){
                                            ClientePJ cliente_pj_na_lista = (ClientePJ) sinistro_na_lista.getCliente();
                                            if(cliente_pj_na_lista.getCnpj().equals(cnpjCliente)){
                                                System.out.println(sinistro_na_lista.toString());
                                            }
                                        }
                                    }
                                }
                                tipoValido = true;
                            }
                            else{
                                System.out.println("Tipo invalido, tente novamente.");
                            }
                        }
                        opcao_valida = true;
                        break;

                    case 4:
                        // listar veiculo por cliente
                        String identificador = "";

                        System.out.print("Digite o tipo do cliente do qual deseja listar os veiculos ('PF' ou 'PJ'): ");
                        tipo_cliente = scanner.nextLine();

                        if(tipo_cliente.equals("PF")){
                            System.out.print("Digite o CPF do cliente do qual deseja listar os veiculos: ");
                            identificador = scanner.nextLine();
                        }
                        else if(tipo_cliente.equals("PJ")){
                            System.out.print("Digite o CNPJ do cliente do qual deseja listar os veiculos: ");
                            identificador = scanner.nextLine();
                        }

                        for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                            for(Cliente cliente_na_lista : seguradora_na_lista.getListaClientes()){
                                if(cliente_na_lista instanceof ClientePF && tipo_cliente.equals("PF")){
                                    ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                                    if(cliente_pf_na_lista.getCpf().equals(identificador)){
                                        cliente_pf_na_lista.listarVeiculos();
                                    }
                                }
                                else if(cliente_na_lista instanceof ClientePJ && tipo_cliente.equals("PJ")){
                                    ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                                    if(cliente_pj_na_lista.getCnpj().equals(identificador)){
                                        cliente_pj_na_lista.listarVeiculos();
                                    }
                                }
                            }
                        }
                          
                        opcao_valida = true;
                        break;
                    
                    case 5:
                        // listar veiculo por seguradora
                        for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                            seguradora_na_lista.listarVeiculos();
                        }
                        opcao_valida = true;
                        break;
                        
                    case 0:
                        // voltar
                        opcao_valida = true;
                        break;

                    default:
                        // erro
                        System.out.println("Tipo invalido, tente novamente.");
                }
            }
        }
    },

    EXCLUIR(3){
        public void executar(Scanner scanner){
            System.out.println("Voce selecionou a opcao 3: excluir.");
            System.out.println("Selecione uma opcao para continuar.");
            System.out.println("1 - Excluir cliente");
            System.out.println("2 - Excluir veiculo");
            System.out.println("3 - Excluir sinistro");
            System.out.println("0 - Voltar");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            String nomeSeguradora;
            boolean opcao_valida = false;
            boolean achou_seguradora;

            while(!opcao_valida){
                switch(opcao){
                    case 1:
                        // excluir cliente da seguradora

                        achou_seguradora = false;
                        while(!achou_seguradora){
                            System.out.print("Digite o nome da seguradora da qual deseja remover o cliente: ");
                            nomeSeguradora = scanner.nextLine();
                        
                            System.out.print("Digite o nome do cliente que deseja remover: ");
                            String nomeCliente = scanner.nextLine();

                            for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){ 
                                if(seguradora_na_lista.getNome().equals(nomeSeguradora)){
                                    seguradora_na_lista.removerCliente(nomeCliente);
                                    achou_seguradora = true;
                                }
                            }
                            if(!achou_seguradora){
                                System.out.println("Seguradora invalida. Tente novamente.");
                            }
                        }
                        opcao_valida = true;
                        break;

                    case 2:
                        // excluir veiculo de cliente de todas as seguradoras

                        String identificador = "";
                        String placa_veiculo;

                        System.out.print("Digite a placa do veiculo que deseja remover: ");
                        placa_veiculo = scanner.nextLine();

                        System.out.print("Digite o tipo do cliente do qual deseja excluir veiculo ('PF' ou 'PJ'): ");
                        String tipo_cliente = scanner.nextLine();

                        if(tipo_cliente.equals("PF")){
                            System.out.print("Digite o CPF do cliente do qual deseja excluir veiculo: ");
                            identificador = scanner.nextLine();
                        }
                        else if(tipo_cliente.equals("PJ")){
                            System.out.print("Digite o CNPJ do cliente do qual deseja excluir veiculo: ");
                            identificador = scanner.nextLine();
                        }

                        for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                            for(Cliente cliente_na_lista : seguradora_na_lista.getListaClientes()){
                                if(cliente_na_lista instanceof ClientePF && tipo_cliente.equals("PF")){
                                    ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                                    if(cliente_pf_na_lista.getCpf().equals(identificador)){
                                        int pos_veiculo = 0;
                                        for(Veiculo veiculo_remover : cliente_pf_na_lista.getListaVeiculos()){
                                            if(veiculo_remover.getPlaca().equals(placa_veiculo)){
                                                cliente_pf_na_lista.removerVeiculo(pos_veiculo);
                                            }
                                            pos_veiculo++;
                                        }
                                    }
                                }
                                else if(cliente_na_lista instanceof ClientePJ && tipo_cliente.equals("PJ")){
                                    ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                                    if(cliente_pj_na_lista.getCnpj().equals(identificador)){
                                        int pos_veiculo = 0;
                                        for(Veiculo veiculo_remover : cliente_pj_na_lista.getListaVeiculos()){
                                            if(veiculo_remover.getPlaca().equals(placa_veiculo)){
                                                cliente_pj_na_lista.removerVeiculo(pos_veiculo);
                                            }
                                            pos_veiculo++;
                                        }
                                    }
                                }
                            }
                        }
                        
                        opcao_valida = true;
                        break;

                    case 3:
                        // excluir sinistro da seguradora
                        System.out.print("Digite o nome da seguradora da qual deseja remover o sinistro: ");
                        nomeSeguradora = scanner.nextLine();
                        System.out.print("Digite o id do sinistro que deseja remover: ");
                        int idSinsitro = scanner.nextInt();
                        scanner.nextLine();

                        for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                            if(seguradora_na_lista.getNome().equals(nomeSeguradora)){
                                seguradora_na_lista.removerSinitro(idSinsitro);
                            }
                        }
                        opcao_valida = true;
                        break;

                    case 0:
                        // voltar
                        opcao_valida = true;
                        break;
                    default:
                        // erro
                        System.out.println("Tipo invalido, tente novamente.");
                }
            }
        }
    },
    
    GERAR_SINISTRO(4){
        public void executar(Scanner scanner){
            System.out.println("Voce selecionou a opcao 4: gerar sinistro.");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            boolean achou_seguradora = false;
                        
            while(!achou_seguradora){
                System.out.print("Digite o nome da seguradora para a qual deseja gerar o sinistro: ");
                String nome_seguradora = scanner.nextLine();
                String tipo_cliente = "", identificador = "";
                String placa_veiculo, endereco_sinistro, data_sinistro_str;
                LocalDate data_sinistro;

                // pegar seguradora da lista de seguradoras (por nome)
                for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                    if(seguradora_na_lista.getNome().equals(nome_seguradora)){
                        achou_seguradora = true;

                        System.out.print("Digite a placa do veiculo envolvido no sinistro: ");
                        placa_veiculo = scanner.nextLine();

                        System.out.print("Digite o endereco em que houve o sinistro: ");
                        endereco_sinistro = scanner.nextLine();

                        System.out.print("Digite a data em que ocorreu o sinistro: ");
                        data_sinistro_str = scanner.nextLine();
                        data_sinistro = LocalDate.parse(data_sinistro_str, formatter);

                        boolean tipo_cliente_valido = false;

                        while(!tipo_cliente_valido){
                            System.out.print("Digite o tipo do cliente para o qual deseja gerar sinistro ('PF' ou 'PJ'): ");
                            tipo_cliente = scanner.nextLine();

                            if(tipo_cliente.equals("PF")){
                                System.out.print("Digite o CPF do cliente para o qual deseja cadastrar o veiculo: ");
                                identificador = scanner.nextLine();
                                tipo_cliente_valido = true;
                            }
                            else if(tipo_cliente.equals("PJ")){
                                System.out.print("Digite o CNPJ do cliente para o qual deseja cadastrar o veiculo: ");
                                identificador = scanner.nextLine();
                                tipo_cliente_valido = true;
                            }
                        }


                        // pegar cliente da lista de clientes da seguradora (por cpf/cnpj) - conferir se esta cadastrado (while)
                        boolean cliente_cadastrado = false;

                        while(!cliente_cadastrado){
                            for(Cliente cliente_na_lista : seguradora_na_lista.getListaClientes()){
                                if(cliente_na_lista instanceof ClientePF && tipo_cliente.equals("PF")){
                                    ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                                    if(cliente_pf_na_lista.getCpf().equals(identificador)){
                                        for(Veiculo veiculo_na_lista : cliente_pf_na_lista.getListaVeiculos()){
                                            // pegar veiculo desse cliente pela placa
                                            if(veiculo_na_lista.getPlaca().equals(placa_veiculo)){
                                                // criar objeto sinistro
                                                Sinistro novo_sinistro = new Sinistro(data_sinistro, endereco_sinistro, seguradora_na_lista, veiculo_na_lista, cliente_pf_na_lista);
                                                seguradora_na_lista.gerarSinistro(novo_sinistro);
                                            }
                                        }

                                        cliente_cadastrado = true;
                                    }
                                }
                                else if(cliente_na_lista instanceof ClientePJ && tipo_cliente.equals("PJ")){
                                    ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                                    if(cliente_pj_na_lista.getCnpj().equals(identificador)){
                                        for(Veiculo veiculo_na_lista : cliente_pj_na_lista.getListaVeiculos()){
                                            // pegar veiculo desse cliente pela placa
                                            if(veiculo_na_lista.getPlaca().equals(placa_veiculo)){
                                                // criar objeto sinistro
                                                Sinistro novo_sinistro = new Sinistro(data_sinistro, endereco_sinistro, seguradora_na_lista, veiculo_na_lista, cliente_pj_na_lista);
                                                seguradora_na_lista.gerarSinistro(novo_sinistro);
                                            }
                                        }
                                        cliente_cadastrado = true;
                                    }
                                }
                            }
                            if(!cliente_cadastrado){
                                System.out.println("Este cliente nao esta cadastrado nesta seguradora. Tente novamente.");
                            }
                        }
                    }
                }
                if(!achou_seguradora){
                    System.out.println("Seguradora invalida. Tente novamente.");
                }
            }
        
        }
        
    },
    TRANSFERIR_SEGURO(5){
        public void executar(Scanner scanner){
            System.out.println("Voce selecionou a opcao 5: transferir seguro.");

            boolean achou_seguradora = false;
                        
            while(!achou_seguradora){
                System.out.print("Digite o nome da seguradora na qual deseja realizar a transferencia de seguro.");
                String nome_seguradora = scanner.nextLine();
                String nome_emissor, nome_receptor;

                for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                    if(seguradora_na_lista.getNome().equals(nome_seguradora)){
                        // aqui
                        System.out.print("Digite o nome do cliente do qual se deseja realizar a transferencia de seguro: ");
                        nome_emissor = scanner.nextLine();

                        for(Cliente cliente_na_lista : seguradora_na_lista.getListaClientes()){
                            if(cliente_na_lista.getNome().equals(nome_emissor)){
                                System.out.print("Digite o nome do cliente para o qual se deseja realizar a transferencia de seguro: ");
                                nome_receptor = scanner.nextLine();
                                for(Cliente cliente_na_lista_2 : seguradora_na_lista.getListaClientes()){
                                    if(cliente_na_lista_2.getNome().equals(nome_receptor)){
                                        int pos_veiculo = 0;
                                        for(Veiculo veiculo_na_lista : cliente_na_lista.getListaVeiculos()){
                                            cliente_na_lista_2.cadastrarVeiculo(veiculo_na_lista);
                                            cliente_na_lista.removerVeiculo(pos_veiculo);   // remove sempre o primeiro
                                        }
                                        // atualizando valores de seguro
                                        cliente_na_lista.setValorSeguro(seguradora_na_lista.calcularPrecoSeguroCliente(cliente_na_lista));
                                        cliente_na_lista_2.setValorSeguro(seguradora_na_lista.calcularPrecoSeguroCliente(cliente_na_lista_2));
                                    }
                                }
                            }
                        }
                        achou_seguradora = true;
                    }
                }

                if(!achou_seguradora){
                    System.out.println("Seguradora invalida. Tente novamente.");
                }
            }
        }
    },

    CALCULAR_RECEITA(6){
        public void executar(Scanner scanner){
            System.out.println("Voce selecionou a opcao 6: calcular receita seguradora.");

            boolean achou_seguradora = false;
            while(!achou_seguradora){
                System.out.print("Digite o nome da seguradora para a qual deseja gerar o sinistro: ");
                String nome_seguradora = scanner.nextLine();

                for(Seguradora seguradora_na_lista : this.getListaSeguradoras()){
                    if(seguradora_na_lista.getNome().equals(nome_seguradora)){
                        System.out.printf("A receita desta seguradora eh %f\n", seguradora_na_lista.calcularReceita());
                        achou_seguradora = true;
                    }
                }

                if(!achou_seguradora){
                    System.out.println("Seguradora invalida. Tente novamente.");
                }
            }
            
        }
    };

    private final int operacao;
    private ArrayList<Seguradora> listaSeguradoras;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
        listaSeguradoras = new ArrayList<Seguradora>();
    }

    public ArrayList<Seguradora> getListaSeguradoras() {
        return listaSeguradoras;
    }

    public void setListaSeguradoras(ArrayList<Seguradora> listaSeguradoras) {
        this.listaSeguradoras = listaSeguradoras;
    }

    public void cadastrarSeguradora(Seguradora seguradora){
        this.listaSeguradoras.add(seguradora);
    }

    public abstract void executar(Scanner scanner);

    public int getOperacao(){
        return this.operacao;
    }
}