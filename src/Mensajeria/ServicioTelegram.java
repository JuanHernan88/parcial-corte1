package mensajeria;

import config.Configuracion;
import interfaces.ServicioMensajeria;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * Servicio que envía mensajes usando la API de Telegram.
 * 
 * @author juan esteban hernandez 
 */
public class ServicioTelegram implements ServicioMensajeria{

    /**
     * Envía un mensaje al chat de Telegram.
     */
    public void enviarMensaje(String mensaje){

        try{

            String urlString =
                    "https://api.telegram.org/bot"
                    + Configuracion.TELEGRAM_TOKEN
                    + "/sendMessage?chat_id="
                    + Configuracion.TELEGRAM_CHAT_ID
                    + "&text="
                    + URLEncoder.encode(mensaje,"UTF-8");

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.getInputStream();

        }catch(Exception e){

            System.out.println("Error enviando mensaje Telegram");
            e.printStackTrace();

        }

    }

}
