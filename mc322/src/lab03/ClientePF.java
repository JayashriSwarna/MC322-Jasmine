package lab03;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

public class ClientePF extends Cliente{
    private String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cpf, String genero,
                    LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica) {
        
        // chamando construtor da superclasse
        super(nome, endereco, listaVeiculos);

        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }


    // Getters and Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }


    // Demais metodos

    public boolean validarCPF(String cpf){
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

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String str = "cpf do cliente: " + cpf + "\n"
                    + "genero: " + genero + "\n"
                    + "data da licenca: " + dataLicenca.format(formatter) + "\n"
                    + "educacao: " + educacao + "\n"
                    + "data de nascimento: " + dataNascimento.format(formatter) + "\n"
                    + "classe economica: " + classeEconomica + "\n";
        return str;
    }
    
}
