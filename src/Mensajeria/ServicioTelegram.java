package mensajeria;

import interfaces.ServicioMensajeria;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ServicioTelegram implements ServicioMensajeria {

    private final String token;
    private final String chatId;

    public ServicioTelegram(String token, String chatId) {
        this.token = token;
        this.chatId = chatId;
    }

    @Override
    public void enviar(String mensaje) {

        try {
            String mensajeCodificado = URLEncoder.encode(
                    mensaje, StandardCharsets.UTF_8);

            String urlString = "https://api.telegram.org/bot"
                    + token
                    + "/sendMessage?chat_id="
                    + chatId
                    + "&text="
                    + mensajeCodificado;

            System.out.println("URL: " + urlString);

            URL url = new URL(urlString);
            HttpURLConnection conexion =
                    (HttpURLConnection) url.openConnection();

            conexion.setRequestMethod("GET");
            conexion.setConnectTimeout(5000);

            int responseCode = conexion.getResponseCode();

            // Leer respuesta de la API
            InputStream inputStream = (responseCode == 200) ? 
                    conexion.getInputStream() : conexion.getErrorStream();
            
            String responseBody = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println("Respuesta: " + responseBody);

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