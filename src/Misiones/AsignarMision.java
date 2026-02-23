/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import heroes.Heroe;
import interfaces.ServicioMensajeria;

public class AsignarMision {

    private ServicioMensajeria servicio;

    public AsignarMision(ServicioMensajeria servicio) {
        this.servicio = servicio;
    }

    public void asignar(Heroe heroe, Mision mision)
            throws MisionNoCompatibleException {

        String estado;
        String icono;

        if (heroe.puedeRealizar(mision)) {
            estado = "APROBADA";
            icono = "✅";
        } else {
            estado = "RECHAZADA";
            icono = "❌";
        }

        String mensaje = """
                🦸 HÉROE: %s
                🎯 MISIÓN: %s
                🔎 Habilidad requerida: %s
                %s ESTADO: %s
                ---------------------------------
              """
                .formatted(
                        heroe.getNombre(),
                        mision.getNombre(),
                        mision.getHabilidadRequerida().getNombre(),
                        icono,
                        estado
                );

        servicio.enviar(mensaje);

        if (!heroe.puedeRealizar(mision)) {
            throw new MisionNoCompatibleException(
                    "El héroe no puede realizar esta misión"
            );
        }
    }
}