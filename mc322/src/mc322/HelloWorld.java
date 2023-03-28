package mc322;

import java.util.*;

public class HelloWorld {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.nextLine();

        String replaceCPF = cpf.replaceAll("\\p{P}", "");
        //replaceCPF = replaceCPF.replaceAll("-", "-");

        System.out.println("o" + cpf);
        System.out.println("u" + replaceCPF);
        
    }
}
