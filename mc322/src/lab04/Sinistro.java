package lab04;

import java.util.Random;
import java.time.LocalDate;
//import java.time.format.DateTimeFormatter; 

public class Sinistro {
    private final int id;
    private LocalDate data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;


    // Construtor
    public Sinistro(LocalDate data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = Sinistro.generateId();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public Seguradora getSeguradora() {
        return seguradora;
    }


    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }


    public Veiculo getVeiculo() {
        return veiculo;
    }


    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    // Outros metodos
    public static int generateId(){
        // Returns number between 0 and 1000000000
        Random random_id = new Random();
        return random_id.nextInt(1000000001);
    }

    public String toString(){
        String str = "id do sinistro: " + id + "\n"
                    + "data: " + data + "\n"
                    + "endereco: " + endereco + "\n"
                    + "seguradora: " + seguradora.getNome() + "\n"
                    + "veiculo (placa): " + veiculo.getPlaca() + "\n"
                    + "nome do cliente: " + cliente.getNome() + "\n";
        return str;
    }
    
}
