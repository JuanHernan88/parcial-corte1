package heroes;

import Interfaces.Habilidad;

public class HabilidadBasica implements Habilidad {

    private String nombre;

    public HabilidadBasica(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
