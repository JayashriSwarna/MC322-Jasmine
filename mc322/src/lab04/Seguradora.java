package lab04;

import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    // Construtor
    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        listaSinistros = new ArrayList<Sinistro>();
        listaClientes = new ArrayList<Cliente>();
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }


    // Demais metodos

    public boolean cadastrarCliente(Cliente cliente){
        /*
         Esta funcao realiza o cadastro de um cliente na seguradora.
         Retorna false se a seguradora ja tiver o cliente cadastrado, dado que cpf e cnpj sao unicos.
         */

        // busca cliente
        for(Cliente cliente_na_lista : this.listaClientes){
            if(cliente_na_lista instanceof ClientePF && cliente instanceof ClientePF){
                ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                ClientePF cliente_pf = (ClientePF) cliente;
                if(cliente_pf_na_lista.getCpf().equals(cliente_pf.getCpf())){
                    System.out.println("Nao eh possivel cadastrar um cliente ja cadastrado.");
                    return false;
                }
            }
            else if(cliente_na_lista instanceof ClientePJ && cliente instanceof ClientePJ){
                ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                ClientePJ cliente_pj = (ClientePJ) cliente;
                if(cliente_pj_na_lista.getCnpj().equals(cliente_pj.getCnpj())){
                    System.out.println("Nao eh possivel cadastrar um cliente ja cadastrado.");
                    return false;
                }
            }
        }

        this.listaClientes.add(cliente);
        return true;
    }


    public boolean removerCliente(String cliente){
        boolean cliente_existe = false;
        int posicao_cliente = 0;

        // verificar se cliente existe pelo nome
        for(Cliente cliente_na_lista : this.listaClientes){
            if(cliente_na_lista.getNome().equals(cliente)){
                cliente_existe = true;
                break;  // acrescentei o break
            }
            posicao_cliente++;
        }

        if(cliente_existe){
            this.listaClientes.remove(posicao_cliente); // tirei o -1
            return true;
        }
        else{
            return false;
        }
    }


    public void listarClientes(String tipoCliente){
        // lista clientes chamando seu metodo toString()

        System.out.println("Lista de Clientes:");
        for(Cliente cliente : this.listaClientes){
            if(cliente instanceof ClientePF && tipoCliente.equals("PF")){
                ClientePF cliente_pf = (ClientePF) cliente;
                System.out.print(cliente_pf.toString());
            }
            else if(cliente instanceof ClientePJ && tipoCliente.equals("PJ")){
                ClientePJ cliente_pj = (ClientePJ) cliente;
                System.out.print(cliente_pj.toString());
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean gerarSinistro(Sinistro sinistro){
        // false: cliente nao existe ou veiculo nao e do cliente
        // cliente nao existe:
        boolean existe_cliente = false, existe_veiculo = false;

        for(Cliente cliente_na_lista : this.listaClientes){
            if(cliente_na_lista instanceof ClientePF && sinistro.getCliente() instanceof ClientePF){
                ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                ClientePF cliente_pf = (ClientePF) sinistro.getCliente();
                if(cliente_pf_na_lista.getCpf().equals(cliente_pf.getCpf())){
                    existe_cliente = true;
                }
            }
            else if(cliente_na_lista instanceof ClientePJ && sinistro.getCliente() instanceof ClientePJ){
                ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                ClientePJ cliente_pj = (ClientePJ) sinistro.getCliente();
                if(cliente_pj_na_lista.getCnpj().equals(cliente_pj.getCnpj())){
                    existe_cliente = true;
                }
            }
        }

        // veiculo nao esta listado para aquele cliente:
        for(Veiculo veiculo_na_lista : sinistro.getCliente().getListaVeiculos()){
            if(veiculo_na_lista.getPlaca().equals(sinistro.getVeiculo().getPlaca())){
                existe_veiculo = true;
            }
        }

        if(!existe_cliente){
            System.out.println("Este cliente nao esta cadastrado nesta seguradora.");
            return false;
        }

        if(!existe_veiculo){
            System.out.println("Este veiculo nao esta cadastrado para este cliente.");
            return false;
        }

        this.listaSinistros.add(sinistro);

        return true;
    }


    public boolean visualizarSinistro(String cliente){
        /* Esta funcao retorna false caso o cliente nao tenha sinistros cadastrados e true se tiver */
        // ver se existe sinistro para aquele cliente
        for(Sinistro sinistro : this.listaSinistros){
            if(sinistro.getCliente().getNome().equals(cliente)){
                return true;
            }
        }

        return false;
    }

    public void removerSinitro(int id_sinistro){
        int posicao_sinistro = 0;
        for(Sinistro sinistro : this.listaSinistros){
            if(sinistro.getId() == id_sinistro){
                this.listaSinistros.remove(posicao_sinistro);
                break;
            }
            posicao_sinistro++;
        }
    }


    public void listarSinistros(){
        // imprimir sinistros
        for(Sinistro sinistro : this.listaSinistros){
            System.out.print(sinistro.toString());
        }
        System.out.println();
    }

    public void listarVeiculos(){
        // listar veiculos por seguradora
        for(Cliente cliente_na_lista : this.listaClientes){
            cliente_na_lista.listarVeiculos();
        }
    }

    public double calcularPrecoSeguroCliente(Cliente cliente){
        
        // armazenar quantidade de sinistros numa variavel
        int quantidadeSinistros = 0;

        // percorrer lista de sinistros da seguradora, acessar cliente e comparar o cpf/cnpj.
        for(Sinistro sinistro_na_lista : this.listaSinistros){
            if(cliente instanceof ClientePF && sinistro_na_lista.getCliente() instanceof ClientePF){
                ClientePF cliente_pf = (ClientePF) cliente;
                ClientePF cliente_pf_sinistro = (ClientePF) sinistro_na_lista.getCliente();
                if(cliente_pf.getCpf().equals(cliente_pf_sinistro.getCpf())){
                    quantidadeSinistros++;
                }
            }
            else if(cliente instanceof ClientePJ && sinistro_na_lista.getCliente() instanceof ClientePJ){
                ClientePJ cliente_pj = (ClientePJ) cliente;
                ClientePJ cliente_pj_sinistro = (ClientePJ) sinistro_na_lista.getCliente();
                if(cliente_pj.getCnpj().equals(cliente_pj_sinistro.getCnpj())){
                    quantidadeSinistros++;
                }
            }
        }

        return cliente.calculaScore() * (1 + quantidadeSinistros);
    }

    public double calcularReceita(){
        double soma = 0.0;

        for(Cliente cliente_na_lista : this.listaClientes){
            soma += this.calcularPrecoSeguroCliente(cliente_na_lista);
        }

        return soma;
    }

}
