/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.model;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mazo 
{
    public ArrayList<Carta> cartas = new ArrayList<>();
    
    public Mazo(String  CantPalos, String dificultad) 
    {
        
        switch(CantPalos)
        {
            case "1 Palo":
            {
                for(int lista=0;lista<8;lista++)
                {
                    for (int a = 1; a <= 13; a++) {
                       cartas.add(new Carta(numero, "/cr/ac/una/solitario_spider/resource/cartas/CORAZON/"+a+"-CORAZON-ROJO.png", "corazon", true));
                    }
                    
                }
                break;
            }
            case "2 Palos":
            {
                for(int lista=0;lista<4;lista++)
                {
                    for (int a = 1; a <= 13; a++) {
                       cartas.add(new Carta(numero, "/cr/ac/una/solitario_spider/resource/cartas/CORAZON/"+a+"-CORAZON-ROJO.png", "corazon", true));
                    }
                    for (int x = 1; x <= 13; x++) {
                       cartas.add(new Carta(numero, "/cr/ac/una/solitario_spider/resource/cartas/PICA/"+x+"-PICA-NEGRA.png", "pica", true));
                    }
                }
                break;
            }
            
            case "4 Palos":
            {
                for(int lista=0;lista<2;lista++)
                {
                    for (int a = 1; a <= 13; a++) {
                       cartas.add(new Carta(numero, "/cr/ac/una/solitario_spider/resource/cartas/CORAZON/"+a+"-CORAZON-ROJO.png", "corazon", true));
                   }
                    for (int x = 1; x <= 13; x++) {
                       cartas.add(new Carta(numero, "/cr/ac/una/solitario_spider/resource/cartas/PICA/"+x+"-PICA-NEGRA.png", "pica", true));
                   }
                     for (int j = 1; j <= 13; j++) {
                       cartas.add(new Carta(numero, "/cr/ac/una/solitario_spider/resource/cartas/ROMBO/"+j+"-ROMBO-ROJO.png", "rombo", true));
                   }
                      for (int k = 1; k <= 13; k++) {
                       cartas.add(new Carta(numero, "/cr/ac/una/solitario_spider/resource/cartas/TREBOL/"+k+"-TREBOL-NEGRO.png", "trebol", true));
                   }
                }
                break;
            }
        }
       
       switch(dificultad)
       {
           case "Facil":
                   {
                        Collections.shuffle(cartas, new Random());
                        break; 
                   }
           case "Medio":
                    {
                        Collections.shuffle(cartas, new Random());
                        Collections.shuffle(cartas, new Random());
                        break;
                    }
           case "Dificil":
                    {
                        Collections.shuffle(cartas, new Random());
                        Collections.shuffle(cartas, new Random());
                        Collections.shuffle(cartas, new Random());
                        break;
                    }
       }
          
    }
  
    
    public Carta getCarta(){
        if (!cartas.isEmpty()){
            return cartas.remove(0);
        } else {
           return null; 
        }
    }
}
