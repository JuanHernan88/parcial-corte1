package heroes;

import interfaces.IHabilidad;

public class HabilidadBasica implements IHabilidad {

    private String nombre;

    public HabilidadBasica(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
