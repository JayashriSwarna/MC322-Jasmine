package lab02;

import java.util.Random;

public class Sinistro {
    private int id;
    private String data;
    private String endereco;

    // Construtor
    public Sinistro(int id, String data, String endereco) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static int generateId(){
        // Returns number between 0 and 1000000000
        Random random_id = new Random();
        return random_id.nextInt(1000000001);
    }
    
}
