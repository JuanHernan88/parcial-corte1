/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

/**
 *
 * @author juanl
 */

import heroes.Heroe;
import java.util.ArrayList;
import java.util.List;

public class SistemaMisiones {

    private List<Heroe> heroes = new ArrayList<>();
    private List<Mision> misiones = new ArrayList<>();

    public void agregarHeroe(Heroe h){
        heroes.add(h);
    }

    public void agregarMision(Mision m){
        misiones.add(m);
    }

    public List<Heroe> getHeroes(){
        return heroes;
    }

    public List<Mision> getMisiones(){
        return misiones;
    }

  
}