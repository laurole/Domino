/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.Ficha;
import clases.Jugador;
import clases.Mesa;
import clases.Par;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Ficha ptr;
        Par auxMesa;
        int cont = 1;
        boolean isValido = false, pasoJugador1, pasoJugador2, salir;
        int res;

        String nombre = (String) JOptionPane.showInputDialog(null, "Escriba el Nombre del Jugador 1", JOptionPane.WARNING_MESSAGE);
        Jugador jugador1 = new Jugador(nombre);

        String nombre2 = (String) JOptionPane.showInputDialog(null, "Escriba el Nombre del Jugador 2", JOptionPane.WARNING_MESSAGE);
        Jugador jugador2 = new Jugador(nombre2);

        ptr = jugador1.getMayorDoble();
        if (ptr == null) {
            ptr = jugador2.getMayorDoble();
            if (ptr == null) { 
                mesa.agregarInicio(new Par(6, 6));
            } else {
                jugador1.borrarFicha(ptr);
                mesa.agregarInicio(new Par(ptr.getLadoA(), ptr.getLadoB()));
            }
        } else {
            jugador1.borrarFicha(ptr);
            mesa.agregarInicio(new Par(ptr.getLadoA(), ptr.getLadoB()));
        }

        String ficha1, ficha2;
        final String[] opciones = new String[]{"Si, Paso", "No"};
        do {
            System.out.println("Ronda " + cont);
            pasoJugador1 = pasoJugador2 = salir = false;
            System.out.println("Fichas en la Mesa \n\n");
            mesa.mostrarMesa();
            System.out.println("\n\n");
            jugador1.mostrarFichas();
            System.out.println("\n\n");

            jugador2.mostrarFichas();
            System.out.println("\n\n");
            res = JOptionPane.showOptionDialog(null, "Jugador " + jugador2.getNombre() + " ¿Desea Pasar?", "Ventana de Dialogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (res == JOptionPane.NO_OPTION) { 
                do {
                    ficha2 = JOptionPane.showInputDialog(null, "Digite el numero de Ficha a Jugar. Jugador: " + jugador2.getNombre(), JOptionPane.QUESTION_MESSAGE);
                    ptr = jugador2.getFichaByIndice(Integer.parseInt(ficha2) - 1);
                    auxMesa = mesa.getPrimero(); 
                    if (ptr.getLadoA().equals(auxMesa.getLadoA())) { 
                        mesa.agregarInicio(new Par(ptr.getLadoB(), ptr.getLadoA()));
                        jugador2.borrarFicha(ptr);
                        isValido = true;
                    } else if (ptr.getLadoB().equals(auxMesa.getLadoA())) { 
                        mesa.agregarInicio(new Par(ptr.getLadoA(), ptr.getLadoB()));
                        jugador2.borrarFicha(ptr);
                        isValido = true;
                    }

                    if (!isValido) { 
                        auxMesa = mesa.getUltimo();
                        if (ptr.getLadoA().equals(auxMesa.getLadoB())) {
                            mesa.agregarFinal(new Par(ptr.getLadoA(), ptr.getLadoB()));
                            jugador2.borrarFicha(ptr);
                            isValido = true;
                        } else if (ptr.getLadoB().equals(auxMesa.getLadoA())) {
                            mesa.agregarFinal(new Par(ptr.getLadoB(), ptr.getLadoA()));
                            jugador2.borrarFicha(ptr);
                            isValido = true;
                        }
                    }

                    if (!isValido) {
                        JOptionPane.showMessageDialog(null, "Ficha Seleccionada No Valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } while (!isValido);
                isValido = false;
                System.out.println("\n\n");
                jugador2.mostrarFichas();

                System.out.println("\n\n");
                System.out.println("Fichas en la Mesa \n\n");
                mesa.mostrarMesa();
                System.out.println("\n\n");
            } else {
                pasoJugador1 = true;
            }

            res = JOptionPane.showOptionDialog(null, "Jugador " + jugador1.getNombre() + " ¿Desea Pasar?", "Ventana de Dialogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (res == JOptionPane.NO_OPTION) { // JUGADOR1
                do {
                    ficha1 = JOptionPane.showInputDialog(null, "Digite el numero de Ficha a Jugar. Jugador: " + jugador1.getNombre(), JOptionPane.QUESTION_MESSAGE);
                    ptr = jugador1.getFichaByIndice(Integer.parseInt(ficha1) - 1);
                    auxMesa = mesa.getPrimero();
                    if (ptr.getLadoA().equals(auxMesa.getLadoA())) {
                        mesa.agregarInicio(new Par(ptr.getLadoB(), ptr.getLadoA()));
                        jugador1.borrarFicha(ptr);
                        isValido = true;
                    } else if (ptr.getLadoB().equals(auxMesa.getLadoA())) {
                        mesa.agregarInicio(new Par(ptr.getLadoA(), ptr.getLadoB()));
                        jugador1.borrarFicha(ptr);
                        isValido = true;
                    }

                    if (!isValido) {
                        auxMesa = mesa.getUltimo();
                        if (ptr.getLadoA().equals(auxMesa.getLadoB())) {
                            mesa.agregarFinal(new Par(ptr.getLadoA(), ptr.getLadoB()));
                            jugador1.borrarFicha(ptr);
                            isValido = true;
                        } else if (ptr.getLadoB().equals(auxMesa.getLadoB())) {
                            mesa.agregarFinal(new Par(ptr.getLadoB(), ptr.getLadoA()));
                            jugador1.borrarFicha(ptr);
                            isValido = true;
                        }
                    }

                    if (!isValido) {
                        JOptionPane.showMessageDialog(null, "Ficha Seleccionada No Valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } while (!isValido);
            } else {
                pasoJugador2 = true;
            }

            if (pasoJugador1 && pasoJugador2) {
                JOptionPane.showMessageDialog(null, "Ambos Jugadores Pasaron!! Pailas!", "Aviso", JOptionPane.WARNING_MESSAGE);
                salir = true;
            } else {
                System.out.println("\n\n");
                jugador1.mostrarFichas();
                System.out.println("\n\n");
                isValido = false;
                System.out.println("\n\n---------------------------------------------------------------");
            }
            cont++;
        } while ((!jugador1.isVectorVacio() && !jugador2.isVectorVacio()) && !salir); 

        int sumaJ1 = jugador1.sumaFichas();
        int sumaJ2 = jugador2.sumaFichas();
        if (sumaJ1 < sumaJ2) {
            JOptionPane.showMessageDialog(null, "El Jugador " + jugador1.getNombre() + " Ha Ganado!!", "Felicidades!", JOptionPane.INFORMATION_MESSAGE);
        } else if (sumaJ2 < sumaJ1) {
            JOptionPane.showMessageDialog(null, "El Jugador " + jugador2.getNombre() + " Ha Ganado!!", "Felicidades!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "NINGUNO GANO!! EMPATE!!", "PAILAS!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
