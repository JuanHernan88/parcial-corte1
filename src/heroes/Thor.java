
package heroes;

import misiones.TipoHabilidad;

public class Thor extends Heroe{

    public Thor(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.ELECTRICIDAD);

    }

}