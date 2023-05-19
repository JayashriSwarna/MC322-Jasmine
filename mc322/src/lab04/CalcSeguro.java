package lab04;

public enum CalcSeguro {
    // Esta classe armazena as constantes de valores para o calculo do seguro.

    VALOR_BASE(100.0),
    FATOR_18_30(1.2),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    public final double valor;
    
    CalcSeguro(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }
}
