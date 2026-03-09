package heroes;

import misiones.TipoHabilidad;

public class Hulk extends Heroe{

    public Hulk(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.FUERZA);

    }

}

