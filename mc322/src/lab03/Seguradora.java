package lab03;

import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    // Construtor
    public Seguradora(String nome, String telefone, String email, String endereco, ArrayList<Sinistro> listaSinistros,
            ArrayList<Cliente> listaClientes) {
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
        // retorna false se cnpj ou cpf forem invalidos
        if(cliente instanceof ClientePF){
            ClientePF cliente_pf = (ClientePF) cliente;
            if(!(cliente_pf.validarCPF(cliente_pf.getCpf()))){
                return false;
            }
        }
        else if(cliente instanceof ClientePJ){
            ClientePJ cliente_pj = (ClientePJ) cliente;
            if(!(cliente_pj.validarCNPJ(cliente_pj.getCnpj()))){
                return false;
            }
        }

        // retorna false se ja houver cliente
        // cpf e cnpj sao unicos
        // busca cliente
        for(Cliente cliente_na_lista : this.listaClientes){
            if(cliente_na_lista instanceof ClientePF && cliente instanceof ClientePF){
                ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                ClientePF cliente_pf = (ClientePF) cliente;
                if(cliente_pf_na_lista.getCpf().equals(cliente_pf.getCpf())){
                    return false;
                }
            }
            else if(cliente_na_lista instanceof ClientePJ && cliente instanceof ClientePJ){
                ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                ClientePJ cliente_pj = (ClientePJ) cliente;
                if(cliente_pj_na_lista.getCnpj().equals(cliente_pj.getCnpj())){
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
            }
            posicao_cliente++;
        }

        if(cliente_existe){
            this.listaClientes.remove(posicao_cliente);
            return true;
        }
        else{
            return false;
        }
    }


    public void listarClientes(String tipoCliente){
        System.out.println("Lista de Clientes:");
        for(Cliente cliente : this.listaClientes){
            if(cliente instanceof ClientePF && tipoCliente.equals("PF")){
                ClientePF cliente_pf = (ClientePF) cliente;
                cliente_pf.toString();
            }
            else if(cliente instanceof ClientePJ && tipoCliente.equals("PJ")){
                ClientePJ cliente_pj = (ClientePJ) cliente;
                cliente_pj.toString();
            }
        }
    }

    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        // false: cliente nao existe ou veiculo nao e do cliente
        // cliente nao existe:
        boolean existe_cliente = false, existe_veiculo = false;

        for(Cliente cliente_na_lista : this.listaClientes){
            if(cliente_na_lista instanceof ClientePF && cliente instanceof ClientePF){
                ClientePF cliente_pf_na_lista = (ClientePF) cliente_na_lista;
                ClientePF cliente_pf = (ClientePF) cliente;
                if(cliente_pf_na_lista.getCpf().equals(cliente_pf.getCpf())){
                    existe_cliente = true;
                }
            }
            else if(cliente_na_lista instanceof ClientePJ && cliente instanceof ClientePJ){
                ClientePJ cliente_pj_na_lista = (ClientePJ) cliente_na_lista;
                ClientePJ cliente_pj = (ClientePJ) cliente;
                if(cliente_pj_na_lista.getCnpj().equals(cliente_pj.getCnpj())){
                    existe_cliente = true;
                }
            }
        }

        // veiculo nao esta listado para aquele cliente:
        for(Veiculo veiculo_na_lista : cliente.getListaVeiculos()){
            if(veiculo_na_lista.getPlaca().equals(veiculo.getPlaca())){
                existe_veiculo = true;
            }
        }

        if((!existe_cliente) || (!existe_veiculo)){
            return false;
        }

        // passar seguradora??

        int id_sinistro = Sinistro.generateId();

        Sinistro sinistro = new Sinistro(id_sinistro, data, endereco, seguradora, veiculo, cliente);
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


    public void listarSinistros(){
        // imprimir sinistros
        for(Sinistro sinistro : this.listaSinistros){
            sinistro.toString();
        }
    }

}
