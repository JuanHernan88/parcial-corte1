/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import heroes.IronMan;
import interfaces.Habilidad;
import interfaces.ServicioMensajeria;
import misiones.*;
import config.Configuracion;

public class Main {

    public static void main(String[] args) {

        Habilidad volar = () -> "Volar";

        IronMan ironMan = new IronMan();

        Mision mision = new Mision("Rescatar civiles", volar);

        ServicioMensajeria servicio = Configuracion.crearServicio();

        AsignarMision asignador = new AsignarMision(servicio);

        try {
            asignador.asignar(ironMan, mision);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}