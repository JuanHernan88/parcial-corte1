package heroes;

import interfaces.Asignable;
import interfaces.Habilidad;
import interfaces.Identificable;
import interfaces.Notificable;
import misiones.Mision;

import java.util.List;

public abstract class Heroe implements Identificable, Asignable, Notificable {

    protected String nombre;
    protected List<Habilidad> habilidades;

    public Heroe(String nombre, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeRealizar(Mision Mision) {

        for (int i = 0; i < habilidades.size(); i++) {
            if (habilidades.get(i).getNombre()
                    .equalsIgnoreCase(Mision.getHabilidadRequerida().getNombre())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificando a " + nombre + ": " + mensaje);
    }
}