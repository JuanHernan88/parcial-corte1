/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import heroes.*;
import mensajeria.ServicioTelegram;
import misiones.*;

import java.util.List;
import interfaces.IHabilidad;
import interfaces.IServicioMensajeria;

/**
 * Punto de entrada del sistema.
 */
public class Main {

    public static void main(String[] args) {

        List<Heroe> heroes = crearHeroes();
        List<Mision> misiones = crearMisiones();

        IServicioMensajeria servicio =
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

        IHabilidad volar = () -> "Volar";
        IHabilidad fuerza = () -> "Fuerza";
        IHabilidad controlTrueno = () -> "ControlDeTrueno";
        IHabilidad trepar = () -> "TreparMuros";
        IHabilidad acuatica = () -> "Acuatica";

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