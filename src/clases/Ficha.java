/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author 10
 */
public enum Ficha {
    cerocero(0,0), cerouno(0,1), cerodos(0,2), cerotres(0,3), cerocuatro(0,4),
    cerocinco(0,5), ceroseis(0,6), unouno(1,1), unodos(1,2), unotres(1,3),
    unocuatro(1,4), unocinco(1,5), unoseis(1,6), dosdos(2,2), dostres(2,3),
    doscuatro(2,4), doscinco(2,5), dosseis(2,6), trestres(3,3), trescuatro(3,4),
    trescinco(3,5), tresseis(3,6), cuatrocuatro(4,4), cuatrocinco(4,5), cuatroseis(4,6),
    cincocinco(5,5), cincoseis(5,6), seisseis(6,6);
    
    Integer ladoA, ladoB; 
    
    Ficha (Integer ladoA, Integer ladoB){
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public Integer getLadoA() {
        return ladoA;
    }

    public Integer getLadoB() {
        return ladoB;
    }
    
    public void mostrar(){
        System.out.print("["+ladoA+"|"+ladoB+"] ");
    }
    
    public boolean isDoble() {
        return (this.ladoA.equals(this.ladoB)); 
    }                                            
}
