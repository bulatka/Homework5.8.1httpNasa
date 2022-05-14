import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class App {
    public static ObjectMapper mapper = new ObjectMapper();
    final private static String URI = "https://api.nasa.gov/planetary/apod?api_key=ntXjctiHfVVq7fA4U1wPsPOZliVyTY1Yeyc2bXCM";

    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet(URI);
        CloseableHttpResponse response = httpClient.execute(request);
        Response responseObj = mapper.readValue(response.getEntity().getContent(), Response.class);

        String uri = responseObj.getUrl();
        request.setURI(new URI(uri));
        response = httpClient.execute(request);
        String[] ss = uri.split("/");

        try (FileOutputStream fos = new FileOutputStream(ss[ss.length-1], true)) {
            byte[] body = response.getEntity().getContent().readAllBytes();
            fos.write(body, 0, body.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}