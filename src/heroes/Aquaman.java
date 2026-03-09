/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heroes;

import misiones.TipoHabilidad;

/**
 * Clase que representa al héroe Aquaman.
 * Tiene la habilidad de controlar el agua.
 * 
 * @author juan jacobo cañas henao
 */
public class Aquaman extends Heroe{

    /**
     * Constructor de Aquaman.
     * Asigna automáticamente la habilidad de agua.
     */
    public Aquaman(String nombre){

        super(nombre);
        agregarHabilidad(TipoHabilidad.AGUA);

    }

}