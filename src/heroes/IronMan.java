
package heroes;

import misiones.TipoHabilidad;

public class IronMan extends Heroe{

    public IronMan(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.VOLAR);

    }

}