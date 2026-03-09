
package misiones;

public class MisionNoCompatibleException extends Exception{

    public MisionNoCompatibleException(){
        super("Ningun heroe puede realizar esta mision");
    }

}
