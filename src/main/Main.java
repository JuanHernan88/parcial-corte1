/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import heroes.IronMan;
import Interfaces.Habilidad;
import Interfaces.ServicioMensajeria;
import Misiones.*;
import config.Configuracion;

import java.util.List;

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