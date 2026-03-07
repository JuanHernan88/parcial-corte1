/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import heroes.Heroe;
import interfaces.ServicioMensajeria;

public class ServicioAsignacionMisiones {

    private ServicioMensajeria servicioMensajeria;

    public ServicioAsignacionMisiones(ServicioMensajeria servicioMensajeria) {
        this.servicioMensajeria = servicioMensajeria;
    }

    public void asignarMision(Heroe heroe, Mision mision)
            throws MisionNoCompatibleException {

        validarMision(mision);
        verificarCompatibilidad(heroe, mision);

        notificarHeroe(heroe, mision);
        notificarSistema(heroe);
    }

    private void validarMision(Mision mision) {
        if (!mision.esValida()) {
            throw new IllegalArgumentException("Misión inválida");
        }
    }

    private void verificarCompatibilidad(Heroe heroe, Mision mision)
            throws MisionNoCompatibleException {

        if (!heroe.puedeRealizar(mision)) {
            throw new MisionNoCompatibleException(
                    "El héroe no puede realizar esta misión");
        }
    }

    private void notificarHeroe(Heroe heroe, Mision mision) {
        heroe.notificar("Se te ha asignado la misión: " + mision.getNombre());
    }

    private void notificarSistema(Heroe heroe) {
        servicioMensajeria.enviar("Misión asignada a " + heroe.getNombre());
    }
}