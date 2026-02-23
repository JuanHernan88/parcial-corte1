package mensajeria;

import interfaces.ServicioMensajeria;

import java.io.IOException;
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

            URL url = new URL(urlString);
            HttpURLConnection conexion =
                    (HttpURLConnection) url.openConnection();

            conexion.setRequestMethod("GET");

            int responseCode = conexion.getResponseCode();

            if (responseCode == 200) {
                System.out.println("Mensaje enviado correctamente a Telegram");
            } else {
                System.out.println("Error al enviar mensaje. Código: "
                        + responseCode);
            }

            conexion.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}