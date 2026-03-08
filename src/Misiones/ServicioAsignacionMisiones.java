/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import heroes.Heroe;
import interfaces.IServicioMensajeria;

public class ServicioAsignacionMisiones {

    private IServicioMensajeria servicioMensajeria;

    public ServicioAsignacionMisiones(IServicioMensajeria servicioMensajeria) {
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
            throw new IllegalArgumentException("Mision invalida");
        }
    }

    private void verificarCompatibilidad(Heroe heroe, Mision mision)
            throws MisionNoCompatibleException {

        if (!heroe.puedeRealizar(mision)) {
            throw new MisionNoCompatibleException(
                    "El heroe no puede realizar esta mision");
        }
    }

    private void notificarHeroe(Heroe heroe, Mision mision) {
        heroe.notificar("Se te ha asignado la mision: " + mision.getNombre());
    }

    private void notificarSistema(Heroe heroe) {
        servicioMensajeria.enviar("Mision asignada a " + heroe.getNombre());
    }
}