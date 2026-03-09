/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heroes;

/**
 *
 * @author juanl
 */

import misiones.TipoHabilidad;

public class Aquaman extends Heroe{

    public Aquaman(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.AGUA);

    }

}