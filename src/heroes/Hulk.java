package heroes;

import misiones.TipoHabilidad;

/**
 * Clase que representa al héroe Hulk.
 * Tiene la habilidad de fuerza.
 * 
 * @author juan jacobo cañas henao
 */
public class Hulk extends Heroe{

    /**
     * Constructor de Hulk.
     * Asigna automáticamente la habilidad de fuerza.
     */
    public Hulk(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.FUERZA);

    }

}