/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heroes;

/**
 *
 * @author juan jacobo cañas henao
 */
public class HeroeFactory {

    public static Heroe crearHeroe(String tipo, String nombre){

        switch(tipo){

            case "IronMan":
                return new IronMan(nombre);

            case "Thor":
                return new Thor(nombre);

            case "Hulk":
                return new Hulk(nombre);

            case "Aquaman":
                return new Aquaman(nombre);

        }

        return null;
    }

}