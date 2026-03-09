/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

public class Mision {

    private String nombre;
    private TipoHabilidad habilidadRequerida;

    public Mision(String nombre, TipoHabilidad habilidadRequerida) {
        this.nombre = nombre;
        this.habilidadRequerida = habilidadRequerida;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoHabilidad getHabilidadRequerida() {
        return habilidadRequerida;
    }

}