/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

import heroes.Heroe;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los héroes y las misiones del sistema.
 * 
 * @author Maribel Ceballos 
 */
public class SistemaMisiones {

    private List<Heroe> heroes = new ArrayList<>();
    private List<Mision> misiones = new ArrayList<>();

    /**
     * Agrega un héroe al sistema.
     */
    public void agregarHeroe(Heroe h){
        heroes.add(h);
    }

    /**
     * Agrega una misión al sistema.
     */
    public void agregarMision(Mision m){
        misiones.add(m);
    }

    /**
     * Devuelve la lista de héroes.
     */
    public List<Heroe> getHeroes(){
        return heroes;
    }

    /**
     * Devuelve la lista de misiones.
     */
    public List<Mision> getMisiones(){
        return misiones;
    }

}