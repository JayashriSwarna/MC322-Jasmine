package lab04;

// classe estatica
public class Validacao {
    /* Esta classe tem como funcao geral efetuar validacao.
        Mais especificamente, esta classe efetua a validacao de um nome, de um cpf e de um cnpj, passados como string.
    */

    public static boolean validarNome(String nome){
        /*
         Esta funcao verifica se o nome eh composto somente por letras e espacos.
         */
        for(int i = 0; i < nome.length(); i++){
            if(!((int)nome.charAt(i) == 32 || ((int)nome.charAt(i) >= 65 && (int)nome.charAt(i) <= 90) || ((int)nome.charAt(i) >= 97 && (int)nome.charAt(i) <= 122))){
                // nao eh espaco nem letra maiuscula nem letra minuscula
                return false;
            }
        }
        return true;
    }

    public static boolean validarCPF(String cpf){
        /*
         Esta funcao aplica o algoritmo de validar cpf.
        */

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
            soma1 += (Integer.valueOf(replaceCPF.charAt(i)) - 48) * verificador1;
            soma2 += (Integer.valueOf(replaceCPF.charAt(i)) - 48) * verificador2;

            verificador1--;
            verificador2--;
        }

        soma2 += (Integer.valueOf(replaceCPF.charAt(9)) - 48) * verificador2;

        int valor = soma1, validador = 9;

        while(valor != -1){
            if(valor % 11 == 0 || valor % 11 == 1){
                if((Integer.valueOf(replaceCPF.charAt(validador)) - 48) != 0){
                    return false;
                }
            }
            else if((Integer.valueOf(replaceCPF.charAt(validador)) - 48) != 11 - (valor % 11)){
                return false;
            }

            if(valor == soma1){
                valor = soma2;
                validador++;
            }
            else{
                valor = -1;
            }
        }     

        return true;
    }

    public static boolean validarCNPJ(String cnpj){
        /*
         Esta funcao aplica o algoritmo de validar cnpj.
        */

        cnpj = cnpj.replaceAll("\\p{P}", "");

        if(cnpj.length() != 14)
            return false;

        int soma1 = 0, soma2 = 0;
        int[] coeficientes = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        for(int i = 0; i < 12; i++){
            soma1 += (Integer.valueOf(cnpj.charAt(i)) - 48) * coeficientes[i + 1];
            soma2 += (Integer.valueOf(cnpj.charAt(i)) - 48) * coeficientes[i];
        }

        soma2 += Integer.valueOf(cnpj.charAt(12)) - 48;

        int valor = soma1, pos = 12;

        while(valor != -1){
            if(valor % 11 == 0 || valor % 11 == 1){
                if(Integer.valueOf(cnpj.charAt(pos)) - 48 != 0){
                    return false;
                }
            }
            else if(Integer.valueOf(cnpj.charAt(pos)) - 48 != 11 - (valor % 11)){
                return false;
            }

            if(valor == soma1){
                valor = soma2;
                pos++;
            }
            else
                valor = -1;
        }

        return true;
    }

}
