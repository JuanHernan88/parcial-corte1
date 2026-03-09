package heroes;

import misiones.TipoHabilidad;

/**
 * Clase que representa al héroe IronMan.
 * Tiene la habilidad de volar.
 * 
 * @author juan jacobo cañas henao
 */
public class IronMan extends Heroe{

    /**
     * Constructor de IronMan.
     * Asigna automáticamente la habilidad de volar.
     */
    public IronMan(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.VOLAR);

    }

}