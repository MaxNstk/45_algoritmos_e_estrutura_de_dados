/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_05_10_recursividade;

/**
 *
 * @author maxna
 */
public class recursividade2 {
    
    public static void main(String[] args) {
//        System.out.println(mdc(17154, 357));
//        System.out.println(binario(37));
        System.out.println(binarioCarlao(37));

    }
    
    
    public static int mdc(int dividendo, int divisor){
        int resto = dividendo % divisor;
        if( resto != 0){
            divisor = mdc(divisor, resto);
        }
        return divisor;
    }
    
    public static String binario(int n){
        if (n < 2){
            return String.valueOf(n);
        }
        else
            binario(n/2);
        return String.valueOf(n) + String.valueOf(n%2);
        
    }
    
    public static String binarioCarlao(int n){
        if (n > 1){
            String resto = String.valueOf(n % 2);
            return binarioCarlao(n/2) + resto;
        }
        return String.valueOf(n);
    }
    
}
