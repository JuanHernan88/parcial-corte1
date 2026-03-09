package misiones;

/**
 * Excepción que se lanza cuando ningún héroe
 * puede realizar una misión.
 * 
 * @author Maribel Ceballos 
 */
public class MisionNoCompatibleException extends Exception{

    /**
     * Constructor con el mensaje de error.
     */
    public MisionNoCompatibleException(){
        super("Ningun heroe puede realizar esta mision");
    }

}
