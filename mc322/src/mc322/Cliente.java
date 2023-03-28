package mc322;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String idade;
    private String endereco;

    // Construtor
    public Cliente(String nome, String cpf, String dataNascimento, String idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static boolean validarCPF(String cpf){
        String replaceCPF = cpf.replaceAll("\\p{P}", "");

        if(replaceCPF.length() != 11)
            return false;

        boolean all_same = true;
        for(int i = 0; i < 10; i++){
            if(replaceCPF.charAt(i) != replaceCPF.charAt(i + 1))
                all_same = false;
        }
        if(all_same)
            return false;
        
        int verificador1 = 10, verificador2 = 11, soma1 = 0, soma2 = 0; 
        for(int i = 0; i < 9; i++){
            soma1 += Integer.valueOf(replaceCPF.charAt(i)) * verificador1;
            soma2 += Integer.valueOf(replaceCPF.charAt(i)) * verificador2;

            verificador1--;
            verificador2--;
        }

        soma2 += Integer.valueOf(replaceCPF.charAt(9)) * verificador2;

        int valor = soma1;

        while(valor != -1){
            if(valor % 11 == 0 || valor % 11 == 1)
                if(Integer.valueOf(replaceCPF.charAt(9)) != 0)
                    return false;
            else if(Integer.valueOf(replaceCPF.charAt(9)) != 11 - (valor % 11))
                return false;

            if(valor == soma1)
                valor = soma2;
            else
                valor = -1;
        }     

        return true;
    }
    
}
