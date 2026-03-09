package misiones;

/**
 * Clase que representa una misión del sistema.
 * Cada misión tiene un nombre y una habilidad requerida.
 * 
 * @author juan esteban hernadez 
 */
public class Mision {

    private String nombre;
    private TipoHabilidad habilidad;

    /**
     * Constructor de la misión.
     */
    public Mision(String nombre, TipoHabilidad habilidad){
        this.nombre = nombre;
        this.habilidad = habilidad;
    }

    /**
     * Devuelve el nombre de la misión.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Devuelve la habilidad necesaria para la misión.
     */
    public TipoHabilidad getHabilidad(){
        return habilidad;
    }

}