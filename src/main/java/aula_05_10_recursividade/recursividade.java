/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_05_10_recursividade;

/**
 *
 * @author maxna
 */
public class recursividade {
    
    public static void main(String[] args) {
//        recursiva(5);
//        System.out.println(somaRecursiva(5));
//        System.out.println(fatorial(5));
//        System.out.println(somaImpar(5));
//        System.out.println(somaImparCarlos(5));
//        System.out.println(potencia(5, 3));
//        System.out.println(potencia(2, 4));
//        System.out.println(mdc(17154, 357));
//        System.out.println(binario(37));
//        System.out.println(binarioCarlao(37));
        
    }
    
    public static  void recursiva(int n){
        System.out.println(n);
        if (n >= 1)
            recursiva(n-1);
        System.out.println(n);
    }
    
    public static int somaRecursiva(int n){
        if (n > 1)
            n += somaRecursiva(n-1);
        return n;
    }
    
    public static int fatorial(int n){
    
        if (n > 1)
            n *= fatorial(n-1);
        return n;
    }
    
    public static int somaImpar(int n){
    // essa porra n funciona
    if (n % 2 != 0 && n != 0)
        n = somaImpar(n-1);
    else if(n!=0)
        n += somaImpar(n-1);
    return n;    
    }
    
   public static int somaImparCarlos(int n){
   
       if (n >1){
           if (n%2 != 0){
               n+= somaImparCarlos(n-2);
           }
           else{
               n = somaImparCarlos(n-1);
           }
       }
       return n;
   }
   
   public static int potencia(int base, int exp){
       
       if (exp > 1){
           base *= potencia(base, exp-1);
       }
       return base;
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
    
    public int enesimoTermo(int n){
        if (n <= 2)
            return 1;
        else
            return enesimoTermo(n-1) + enesimoTermo(n-2);
    }
    
}
