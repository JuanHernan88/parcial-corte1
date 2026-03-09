package config;

/**
 * Clase que guarda las configuraciones del sistema,
 * como el token y el chat de Telegram.
 * 
 * @author Maribel Ceballos
 */
public class Configuracion {

    /** Token del bot de Telegram */
    public static final String TELEGRAM_TOKEN =
            System.getenv("TELEGRAM_TOKEN");

    /** ID del chat donde se envían los mensajes */
    public static final String TELEGRAM_CHAT_ID =
            System.getenv("TELEGRAM_CHAT_ID");

}