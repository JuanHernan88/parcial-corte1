
package misiones;

public class Mision {

    private String nombre;
    private TipoHabilidad habilidad;

    public Mision(String nombre, TipoHabilidad habilidad){
        this.nombre = nombre;
        this.habilidad = habilidad;
    }

    public String getNombre(){
        return nombre;
    }

    public TipoHabilidad getHabilidad(){
        return habilidad;
    }

}