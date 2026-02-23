/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import heroes.*;
import interfaces.Habilidad;
import interfaces.ServicioMensajeria;
import java.util.ArrayList;
import java.util.List;
import mensajeria.ServicioTelegram;
import misiones.*;

public class Main {

    public static void main(String[] args) {

        // Crear habilidades
        Habilidad volar = () -> "Volar";
        Habilidad fuerza = () -> "Fuerza";
        Habilidad controlTrueno = () -> "ControlDeTrueno";
        Habilidad trepar = () -> "TreparMuros";
        Habilidad acuatica = () -> "Acuatica";

        // Crear lista de superhéroes
        List<Heroe> heroes = new ArrayList<>();
        heroes.add(new IronMan());
        heroes.add(new Thor());
        heroes.add(new Hulk());
        heroes.add(new SpiderMan());
        heroes.add(new Aquaman());

        // Crear misiones
        List<Mision> misiones = new ArrayList<>();
        misiones.add(new Mision("Rescatar civiles", volar));
        misiones.add(new Mision("Controlar tormenta", controlTrueno));
        misiones.add(new Mision("Destruir obstáculos", fuerza));
        misiones.add(new Mision("Infiltrarse en edificio", trepar));
        misiones.add(new Mision("Rescate submarino", acuatica));

        // Configurar servicio de Telegram
        String tokenTelegram = "8772824289:AAFlcHu2sySiKjF68FJV1YEcjUDs-b6YbO4";
        String chatIdTelegram = "5895943444";

        ServicioMensajeria servicioTelegram =
                new ServicioTelegram(tokenTelegram, chatIdTelegram);

        AsignarMision asignador = new AsignarMision(servicioTelegram);

        for (Heroe heroe : heroes) {
            for (Mision mision : misiones) {

                System.out.println("→ Evaluando " + heroe.getNombre() +
                        " para misión: " + mision.getNombre());

                try {
                    asignador.asignar(heroe, mision);
                    System.out.println("  ✓ Resultado enviado a Telegram\n");
                } catch (MisionNoCompatibleException e) {
                    System.out.println("  ✗ " + e.getMessage() + "\n");
                } catch (Exception e) {
                    System.out.println("  ✗ Error: " + e.getMessage() + "\n");
                }
            }
        }
    }
}