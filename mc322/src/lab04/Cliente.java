package lab04;

import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;

    // Construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        listaVeiculos = new ArrayList<Veiculo>();
    }


    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        this.listaVeiculos.add(veiculo);
    }

    public void removerVeiculo(int posicao_veiculo){
        this.listaVeiculos.remove(posicao_veiculo);
    }

    public void listarVeiculos(){
        // imprimir veiculos
        int contador = 1;
        for(Veiculo veiculo : listaVeiculos){
            System.out.println("Veiculo " + contador + "\n" + veiculo.toString());
            contador++;
        }
        System.out.println();
    }

    public abstract double calculaScore();


    public String toString(){
        String str = "nome do cliente: " + nome + "\n"
                    + "endereco: " + endereco + "\n"
                    + "Lista de veiculos do cliente:" + "\n";

        int contador = 1;

        for(Veiculo veiculo : listaVeiculos){
            str = str + "Veiculo " + contador + "\n" + veiculo.toString() + "\n";
            contador++;
        }

        str = str + "Valor do seguro do cliente: " + valorSeguro + "\n";
        return str;
    }
    
}
