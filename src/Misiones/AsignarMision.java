/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import heroes.Heroe;
import java.util.List;

public class AsignarMision {

    public Heroe asignar(Mision mision, List<Heroe> heroes) {

        for (Heroe h : heroes) {

            if (h.getHabilidades().contains(mision.getHabilidadRequerida())) {
                return h;
            }

        }

        throw new MisionNoCompatibleException(
                "Ningún héroe puede realizar la misión"
        );
    }
}