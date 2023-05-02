package lab03;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;

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

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        this.listaVeiculos.add(veiculo);
    }

    public String toString(){
        String str = "nome do cliente: " + nome + "\n"
                    + "endereco: " + endereco + "\n"
                    + "Lista de veiculos do cliente:" + "\n";

        int contador = 1;

        for(Veiculo veiculo : listaVeiculos){
            str = str + "Veiculo " + contador + "\n" + veiculo.toString() + "\n";
            contador++;
        }
        return str;
    }
    
}
