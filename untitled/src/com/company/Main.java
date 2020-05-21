package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean ahorcado = false;
    static boolean hasGanado = false;
    static boolean hasPerdido = false;
    static int vidas = 5;

    public static void main(String[] args) {
        String[] palabras = {"fiesta", "disfraz", "teclado", "publicidad", "ordenador", "videoconsola", "muebles"};
        int posicionRandom = (int) Math.floor(Math.random() * palabras.length);
        String palabra = palabras[posicionRandom];



        char[] letras = palabra.toCharArray();
        char[] letrasGuiones = new char[letras.length];

        for (int i = 0; i < letras.length; i++) {
            letrasGuiones[i] = '_';

        }
        System.out.println(letrasGuiones);




        boolean estaletra = false;


        while (ahorcado == false) {
            System.out.println(palabra);
            System.out.println("---------------");
            System.out.println("vidas: " + vidas);
            System.out.println("PON UNA LETRA!");
            Scanner jugador = new Scanner(System.in);
            char letraIntroducida = jugador.next().charAt(0);



            for (int i = 0; i < letras.length; i++) {
                if (letras[i] == letraIntroducida) {
                    letrasGuiones[i] = letraIntroducida;
                    estaletra = true;
                }
            }
            if (!estaletra) {
                vidas--;

            }
                System.out.println(letrasGuiones);

            if (vidas == 0) {
                System.out.println("HAS PERDIDO!!");
                hasPerdido = true;
                ahorcado = true;
                volverJugar();
            }

            if (Arrays.equals(letras, letrasGuiones)) {
                System.out.println("HAS GANADO!");
                hasGanado = true;
                ahorcado = true;
                volverJugar();
            }


        }

    }
    static void volverJugar() {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        System.out.println(" ");
        if (hasGanado || hasPerdido) {
            System.out.println("¿Quieres volver a jugar? (s/n)");
            respuesta = scanner.next();
            if (respuesta.equals("s")) {
                ahorcado = false;
                vidas = 5;

            } else {
                ahorcado = true;
            }
        }
    }
}
