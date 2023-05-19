package lab04;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter; 

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, String cpf, String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica) {
        
        // chamando construtor da superclasse
        super(nome, endereco);

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

    public double calculaScore(){
        // Este metodo calcula o score de um cliente do tipo PF.

        // obter idade em anos
        Period tempo_passado = Period.between(dataNascimento, LocalDate.now());
        int idade = tempo_passado.getYears();
        int quantidadeCarros = this.getListaVeiculos().size();

        double retorno = CalcSeguro.VALOR_BASE.getValor();

        if(idade >= 18 && idade < 30){
            return retorno * CalcSeguro.FATOR_18_30.getValor() * quantidadeCarros;
        }
        else if(idade >= 30 && idade < 60){
            return retorno * CalcSeguro.FATOR_30_60.getValor() * quantidadeCarros;
        }
        else if(idade >= 60 && idade < 90){
            return retorno * CalcSeguro.FATOR_60_90.getValor() * quantidadeCarros;
        }
        else{
            System.out.println("Idade invalida.");
            return 0.0;
        }
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
