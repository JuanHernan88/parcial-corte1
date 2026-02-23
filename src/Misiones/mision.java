/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import interfaces.*;

public class Mision implements Identificable, Validable {

    private String nombre;
    private Habilidad habilidadRequerida;

    public Mision(String nombre, Habilidad habilidadRequerida) {
        this.nombre = nombre;
        this.habilidadRequerida = habilidadRequerida;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public Habilidad getHabilidadRequerida() {
        return habilidadRequerida;
    }

    @Override
    public boolean esValida() {
        return habilidadRequerida != null && nombre != null;
    }
}