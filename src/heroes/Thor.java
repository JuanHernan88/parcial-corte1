package heroes;

import misiones.TipoHabilidad;

/**
 * Clase que representa al héroe Thor.
 * Tiene la habilidad de electricidad.
 * 
 * @author juan jacobo cañas henao
 */
public class Thor extends Heroe{

    /**
     * Constructor de Thor.
     * Asigna automáticamente la habilidad de electricidad.
     */
    public Thor(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.ELECTRICIDAD);

    }

}