/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import interfaces.*;

public class Mision implements IIdentificable, IValidable {

    private String nombre;
    private IHabilidad habilidadRequerida;

    public Mision(String nombre, IHabilidad habilidadRequerida) {
        this.nombre = nombre;
        this.habilidadRequerida = habilidadRequerida;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public IHabilidad getHabilidadRequerida() {
        return habilidadRequerida;
    }

    @Override
    public boolean esValida() {
        return habilidadRequerida != null && nombre != null;
    }
}