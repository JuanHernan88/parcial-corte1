/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import interfaces.IHabilidad;
import interfaces.IIdentificable;
import interfaces.IValidable;


public class Mision implements IIdentificable, IValidable {

    private final String nombre;
    private final IHabilidad habilidadRequerida;

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
        return nombre != null && !nombre.trim().isEmpty()
                && habilidadRequerida != null;
    }
}