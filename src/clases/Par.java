/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

public class Par {
    private int ladoA;
    private int ladoB;
    
    public Par(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }
    
    public int getLadoA() { return this.ladoA; }
    public int getLadoB() { return this.ladoB; }
    
    public void mostrar(){
        System.out.print("["+ladoA+"|"+ladoB+"] ");
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.ladoA;
        hash = 89 * hash + this.ladoB;
        return hash;
    }

    @Override
    public boolean equals(Object obj) { 
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Par other = (Par) obj;
        if (this.ladoA != other.ladoA) {
            return false;
        }
        return this.ladoB == other.ladoB;
    } 
}
