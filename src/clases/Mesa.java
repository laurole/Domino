/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.LinkedList;

public class Mesa {
    private LinkedList<Par> fichasMesa;

    public Mesa() {
        this.fichasMesa = new LinkedList<>();
    }
    
    public void agregarInicio(Par p){ 
        this.fichasMesa.addFirst(p);
    }
    
    public void agregarFinal(Par p){ 
        this.fichasMesa.addLast(p);
    }
    
    public void mostrarMesa(){
        for(Par p : fichasMesa){
            p.mostrar();
        }
    }
    
    public Par getPrimero() {
        return this.fichasMesa.getFirst();
    }
    
    public Par getUltimo() {
        return this.fichasMesa.getLast();
    }
}