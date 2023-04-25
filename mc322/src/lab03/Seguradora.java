package lab03;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static boolean cadastrarCliente(Cliente cliente, ArrayList<Cliente> listaClientes){
        listaClientes.add(cliente);
        return true;
        // PENSAR EM QUANDO RETORNAR FALSE - ideia: cpf invalico
    }

    public static boolean removerCliente(Cliente cliente, ArrayList<Cliente> listaClientes){
        if(!(listaClientes.contains(cliente))){     // lista nao contem cliente
            return false;
        }
        else{
            //listaClientes.remove(Arrays.binarySearch(listaClientes, cliente));
            // achar posicao do objeto
            // listaClientes.remove(posicao);
        }
        return true;
    }

    public static void listarClientes(String tipoCliente, ArrayList<Cliente> listaClientes){
        for(Cliente cliente : listaClientes){
            // if
            // ver qual o tipo do cliente comparando com tipoCliente
            // chamar toString do cliente
        }
    }

    public static boolean gerarSinistro(){
        // Pensar nas condicoes para false
        // new sinistro
        // gerar id
        return true;
    }

    public static boolean visualizarSinistro(String cliente){
        // ver se existe
        return true;
    }

    public static void listarSinistros(){
        // imprimir sinistros
    }
    
    
    
}
