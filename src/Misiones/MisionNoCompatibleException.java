/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misiones;

/**
 * Excepción que se lanza cuando un héroe no puede realizar una misión.
 */
public class MisionNoCompatibleException extends Exception {

    public MisionNoCompatibleException() {
        super();
    }

    public MisionNoCompatibleException(String mensaje) {
        super(mensaje);
    }

    public MisionNoCompatibleException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}