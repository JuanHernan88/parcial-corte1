/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import heroes.IronMan;
import interfaces.Habilidad;
import interfaces.ServicioMensajeria;
import mensajeria.ServicioTelegram;
import misiones.*;

public class Main {

    public static void main(String[] args) {

        // Crear habilidad
        Habilidad volar = () -> "Volar";

        // Crear héroe
        IronMan ironMan = new IronMan();

        // Crear misión
        Mision mision = new Mision("Rescatar civiles", volar);

        String tokenTelegram = "8772824289:AAFlcHu2sySiKjF68FJV1YEcjUDs-b6YbO4";
        String chatIdTelegram = "1233282815";

        ServicioMensajeria servicioTelegram =
                new ServicioTelegram(tokenTelegram, chatIdTelegram);

        AsignarMision asignador =
                new AsignarMision(servicioTelegram);

        try {
            asignador.asignar(ironMan, mision);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}