/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoscirculares;

/**
 *
 * @author Marcelo
 */
import java.util.ArrayList;
public class PrimosCirculares {

    /**
     * @param args the command line arguments
     */
static ArrayList  <Integer> z = new ArrayList();
//static ArrayList  <Integer> primos = new ArrayList();
static int cant =0;
static int cantc =0;
    public static void main (String[] args) throws InterruptedException { 
   

       
 pasouno hilo1 = new pasouno(2,99);                        
 pasouno hilo2 = new pasouno(100,999);
 pasouno hilo3 = new pasouno(1000,9999);
 pasouno hilo4 = new pasouno(10000,99999);
 pasouno hilo5 = new pasouno(100000,999999);
  hilo1.start();
 hilo2.start();
  hilo3.start();
hilo4.start();
  hilo5.start();
 
 hilo1.join();
 hilo2.join();
 hilo3.join();
 hilo4.join();
 hilo5.join();
 System.out.println ("la cantidad de numeros primos en un millon es : "+cant);
 System.out.println ("la cantidad de numeros primos circulares en un millon es: "+cantc);
 System.out.println ("la lista de primos criculares es : ");
       for (int i = 0; i < z.size(); i++)
       {
           System.out.println ("  "+z.get(i));
           
       }
 
 
 
 
 




       
   }
}

    
