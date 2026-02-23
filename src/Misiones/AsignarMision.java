/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Misiones;

import heroes.Heroe;
import Interfaces.ServicioMensajeria;

public class AsignarMision {

    private ServicioMensajeria servicio;

    public AsignarMision(ServicioMensajeria servicio) {
        this.servicio = servicio;
    }

    public void asignar(Heroe heroe, Mision mision)
            throws MisionNoCompatibleException {

        if (!mision.esValida()) {
            throw new IllegalArgumentException("Misión inválida");
        }

        if (!heroe.puedeRealizar(mision)) {
            throw new MisionNoCompatibleException(
                    "El héroe no puede realizar esta misión");
        }

        heroe.notificar("Se te ha asignado la misión: " + mision.getNombre());
        servicio.enviar("Misión asignada a " + heroe.getNombre());
    }
}