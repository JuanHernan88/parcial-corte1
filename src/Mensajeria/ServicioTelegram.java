package mensajeria;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import interfaces.IServicioMensajeria;

/**
 * Implementación del servicio de mensajería para enviar mensajes
 * a través de la API oficial de Telegram Bot.
 *
 * <p>Esta clase utiliza una conexión HTTP GET hacia la API:
 * https://api.telegram.org/bot{token}/sendMessage</p>
 *
 * <p>Requiere un token de bot y un chatId previamente configurados.</p>
 *
 * @author Jacobo
 * @version 1.0
 */
public class ServicioTelegram implements IServicioMensajeria {

    /**
     * Token del bot proporcionado por BotFather.
     */
    private final String token;

    /**
     * Identificador del chat al cual se enviarán los mensajes.
     */
    private final String chatId;

    /**
     * Constructor del servicio de Telegram.
     *
     * @param token  Token del bot generado por Telegram.
     * @param chatId ID del chat de destino.
     */
    public ServicioTelegram(String token, String chatId) {
        this.token = token;
        this.chatId = chatId;
    }

    /**
     * Envía un mensaje al chat configurado utilizando la API de Telegram.
     *
     * <p>El mensaje es codificado en UTF-8 antes de enviarse.
     * Se realiza una petición HTTP GET y se evalúa el código
     * de respuesta para determinar si el envío fue exitoso.</p>
     *
     * @param mensaje Texto que se enviará al chat.
     */
    @Override
    public void enviar(String mensaje) {

        try {
            // Codifica el mensaje para evitar errores por caracteres especiales
            String mensajeCodificado = URLEncoder.encode(
                    mensaje, StandardCharsets.UTF_8);

            // Construcción de la URL de la API
            String urlString = "https://api.telegram.org/bot"
                    + token
                    + "/sendMessage?chat_id="
                    + chatId
                    + "&text="
                    + mensajeCodificado;

            System.out.println("URL: " + urlString);

            // Apertura de conexión HTTP
            URL url = new URL(urlString);
            HttpURLConnection conexion =
                    (HttpURLConnection) url.openConnection();

            conexion.setRequestMethod("GET");
            conexion.setConnectTimeout(5000);

            // Obtener código de respuesta
            int responseCode = conexion.getResponseCode();

            // Leer respuesta de la API
            InputStream inputStream = (responseCode == 200)
                    ? conexion.getInputStream()
                    : conexion.getErrorStream();

            String responseBody = new String(
                    inputStream.readAllBytes(),
                    StandardCharsets.UTF_8
            );

            System.out.println("Respuesta: " + responseBody);

            // Validación del resultado
            if (responseCode == 200) {
                System.out.println("✓ Mensaje enviado correctamente a Telegram");
            } else {
                System.out.println("✗ Error al enviar mensaje. Código: "
                        + responseCode);
                System.out.println("Detalles: " + responseBody);
            }

            conexion.disconnect();

        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}