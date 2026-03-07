/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import heroes.*;
import interfaces.Habilidad;
import interfaces.ServicioMensajeria;
import mensajeria.ServicioTelegram;
import misiones.*;

import java.util.List;

/**
 * Punto de entrada del sistema.
 */
public class Main {

    public static void main(String[] args) {

        List<Heroe> heroes = crearHeroes();
        List<Mision> misiones = crearMisiones();

        ServicioMensajeria servicio =
                new ServicioTelegram("TOKEN", "CHAT_ID");

        ServicioAsignacionMisiones asignador =
                new ServicioAsignacionMisiones(servicio);

        ejecutarAsignaciones(heroes, misiones, asignador);
    }

    private static List<Heroe> crearHeroes() {
        return List.of(
                new IronMan(),
                new Thor(),
                new Hulk(),
                new SpiderMan(),
                new Aquaman()
        );
    }

    private static List<Mision> crearMisiones() {

        Habilidad volar = () -> "Volar";
        Habilidad fuerza = () -> "Fuerza";
        Habilidad controlTrueno = () -> "ControlDeTrueno";
        Habilidad trepar = () -> "TreparMuros";
        Habilidad acuatica = () -> "Acuatica";

        return List.of(
                new Mision("Rescatar civiles", volar),
                new Mision("Controlar tormenta", controlTrueno),
                new Mision("Destruir obstaculos", fuerza),
                new Mision("Infiltrarse en edificio", trepar),
                new Mision("Rescate submarino", acuatica)
        );
    }

    private static void ejecutarAsignaciones(
            List<Heroe> heroes,
            List<Mision> misiones,
            ServicioAsignacionMisiones asignador) {

        for (Heroe heroe : heroes) {
            for (Mision mision : misiones) {

                System.out.println(" Evaluando " + heroe.getNombre()
                        + " para mision: " + mision.getNombre());

                try {
                    asignador.asignarMision(heroe, mision);
                    System.out.println(" Resultado enviado\n");

                } catch (MisionNoCompatibleException e) {
                    System.out.println("   " + e.getMessage() + "\n");

                } catch (Exception e) {
                    System.out.println(" Error: " + e.getMessage() + "\n");
                }
            }
        }
    }
}