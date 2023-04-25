package lab03;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientePJ extends Cliente{
    private String cnpj;
    private LocalDate dataFundacao;
    
    // Construtor
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cnpj, LocalDate dataFundacao) {
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }


    // Getters and Setters

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }


    // Demais metodos
    public boolean validarCNPJ(String cnpj){
        cnpj = cnpj.replaceAll("\\p{P}", "");

        if(cnpj.length() != 14)
            return false;

        int soma1 = 0, soma2 = 0;
        int[] coeficientes = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for(int i = 0; i < 12; i++){
            soma1 += Integer.valueOf(cnpj.charAt(i)) * coeficientes[i + 1];
            soma2 += Integer.valueOf(cnpj.charAt(i)) * coeficientes[i];
        }

        soma2 += Integer.valueOf(cnpj.charAt(12));

        int valor = soma1, pos = 12;

        while(valor != -1){
            if(valor % 11 == 0 || valor % 11 == 1)
                if(Integer.valueOf(cnpj.charAt(pos)) != 0)
                    return false;
            else if(Integer.valueOf(cnpj.charAt(pos)) != 11 - (valor % 11))
                return false;

            if(valor == soma1){
                valor = soma2;
                pos++;
            }
            else
                valor = -1;
        }

        return true;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String str = "cnpj do cliente: " + cnpj + "\n"
                    + "data de fundacao: " + dataFundacao.format(formatter) + "\n";
        return str;
    }

}
