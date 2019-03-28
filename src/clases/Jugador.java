/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Random;

public class Jugador {

    private String nombre;
    private ArrayList<Ficha> fichas; 
    private static int numj = 1; 
    private static ArrayList<Ficha> fichasRepetidas = new ArrayList<>(); 

    // constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.fichas = new ArrayList<>(7); 
        repartirFichas();
    }

    //constructor parametrizado
    public Jugador() {
        this(String.valueOf(numj)); 
        numj++;
    }
    //get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

// metodo
    private void repartirFichas() {
        Random random = new Random();
        Ficha[] vector = Ficha.values(); 
        for (int i = 0; i < 7; i++) {    
            Ficha f; 
            do {
                f = vector[random.nextInt(vector.length)]; 
            } while (fichas.contains(f) || fichasRepetidas.contains(f)); 
            fichas.add(f);
            fichasRepetidas.add(f);
        }

    }

    public void mostrarFichas() {
        System.out.println("Fichas del jugador: " + nombre);
        for (Ficha f : fichas) { 
            f.mostrar();
        }
    }

    public Ficha getMayorDoble() {
        
        for (Ficha f : fichas) {
            if (f.isDoble()) { 
                return f; 
            }
        }

        
        return null;
    }
    
    public Ficha getFichaByIndice(int index) {  
        return this.fichas.get(index);
    }

    public void borrarFicha(Ficha f) { 
        this.fichas.remove(f);
    }

    public boolean isVectorVacio() {
        return this.fichas.isEmpty(); 
    }                                  

    public int sumaFichas(){
        int suma=0;
        for( Ficha f: fichas){
            suma += f.getLadoA()+f.getLadoB();
        }
        return suma;
    }
}
