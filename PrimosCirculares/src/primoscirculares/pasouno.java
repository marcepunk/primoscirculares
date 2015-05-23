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

import static primoscirculares.PrimosCirculares.z;          // hago uso de variables globales por que tuve problemas
import static primoscirculares.PrimosCirculares.cant;       //con la sincronizacion de los hilos
import static primoscirculares.PrimosCirculares.cantc;

public class pasouno extends Thread 
{
   
   public ArrayList <Integer> primos = new ArrayList();         //uso un arreglo dinamico
   //public static ArrayList <Integer> z = new ArrayList();
    ArrayList <Integer> a = new ArrayList();
    int desde,hasta;
    int cuantos=0,k=-1;
   

    public pasouno(){}
    public pasouno(int desde, int hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    public ArrayList<Integer> getPrimos() {
        return primos;
    }


    @Override
	public void run() 
        {
           
            for(int i=desde;i<=hasta;i++) // agrego a partir del dos por que considerare al uno no primo 
        {      
            if (i%2!=0)
            {     
                
               String p= String.valueOf(i);
                //String h= Integer.toString(i);
                if(p.contains("0"))
                {
                      //System.out.println("saca los que tiene ceros");
                }
                else
                {
                    
                    a.add(i);
                    k++;
                            
                     int contador = 2;                 
                     boolean primo=true;
                while ((primo) && (contador!=a.get(k))){
                  if (a.get(k) % contador == 0)
                           primo = false;
                         contador++;
                       }
                        if (primo)
                       {
                          // System.out.println ("es primo: "+a.get(k));
                            cuantos= cuantos +1;
                            
                            primos.add(a.get(k));
                            
                       }
                            
        
                }
          
        
            }
        }
           
        cant = cant + cuantos;
        //System.out.println ("y por fin la cantidad de numeros primos en un millon es:  "+cuantos+" y el tamaño de arraylist primos es es "+primos.size());
    
               
       //////////////////////////buscando los circulares////////////////////////////////////
         for(int i=0;i<primos.size();i++)
            {
               String b = primos.get(i).toString();
               
               char[] despla = b.toCharArray();
               boolean circu= true;
               int cuenta = 0;
              
               
               while ((circu) && (cuenta<despla.length)) //busco si es circular el numero primo
               {
                   if (despla.length==1)                  //esta parte no tiene nada optimo
                   {
                       circu= false;
                       
                   }
                    if (despla.length==2)                  
                   {
                     
                   String caracter = new String(despla);
                   int nume= Integer.parseInt(caracter); //todo bien hasta aca
                   
                  if( primos.contains(nume))
                  {
                      cuenta=despla.length;
                      
                      cantc= cantc +1;
                      z.add(nume);
                    
                  }
                  else
                  {
                      circu= false;
                  }
                   
                   }
                    
                    /////////////////////////////////
                    if (despla.length==3)                  //en esta parte evaluo el tamaño del numero 
                   {                                       //y muevo sus digitos de lugar para buscar si el nuevo numero es primo
                                                           // y de tal forma comprobar si es un primo circular
                       rotar(despla);
                  
                   String caracter = new String(despla);
                   
                   int nume= Integer.parseInt(caracter);
                   
                   
                  if( primos.contains(nume))
                  {
                      cuenta++;
                      if(cuenta == despla.length )
                      {
                             z.add(nume);
                            cantc= cantc +1;

                      }
                    
                  }
                  else
                  {
                      circu=false;
                  }
                   
       

    }

                      if (despla.length==4) 
                      {
                 
                          
                  rotar(despla);
                            String caracter = new String(despla);
                            int nume= Integer.parseInt(caracter); //todo bien hasta aca
                   
                       if( primos.contains(nume))
                  {
                      cuenta++;
                      if(cuenta == despla.length )
                      {
                             z.add(nume);
                             cantc= cantc +1;
                      }
                    
                  }
                  else
                  {
                      circu=false;
                  } 

    
    
}
                   if (despla.length==5) 
                      {
                  
                          
                  rotar(despla);
                            String caracter = new String(despla);
                            int nume= Integer.parseInt(caracter); //todo bien hasta aca
                   
                       if( primos.contains(nume))
                  {
                      cuenta++;
                      if(cuenta == despla.length )
                      {
                             z.add(nume);
                           cantc= cantc +1;

                      }
                   }
                  else
                  {
                      circu=false;
                  } 
    
}
                   if (despla.length==6) 
                      {
                  
                          
                  rotar(despla);
                            String caracter = new String(despla);
                            int nume= Integer.parseInt(caracter); //todo bien hasta aca
                   
                       if( primos.contains(nume))
                  {
                      cuenta++;
                      if(cuenta == despla.length )
                      {
                             z.add(nume);
                             cantc= cantc +1;
                      }
                    
                  }
                  else
                  {
                      circu=false;
                  } 

}

}
    }
               /*Iterator j = z.iterator();
                 while(j.hasNext())
                System.out.println(j.next());*/
      
    }
     public  char[] rotar(char[] c)   //funcion que me permite rotar los numeros primos 
 {
  char primero = c[0];
  int x;
 
  for(x= 0; x<c.length-1; x++)
  { c[x] = c[x+1];}
 
  c[x]= primero;
  return c;
}
}
