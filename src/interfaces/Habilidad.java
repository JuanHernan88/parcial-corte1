
package interfaces;

/**
 * Clase que representa una habilidad con un nombre.
 * 
 * @author Maribel Ceballos 
 */
public class Habilidad {

    private String nombre;

    /**
     * Constructor de la habilidad.
     */
    public Habilidad(String nombre){
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre de la habilidad.
     */
    public String getNombre(){
        return nombre;
    }
}