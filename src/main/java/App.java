import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class App {
    public static ObjectMapper mapper = new ObjectMapper();
    final private static String URI = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=ntXjctiHfVVq7fA4U1wPsPOZliVyTY1Yeyc2bXCM");
        CloseableHttpResponse response = httpClient.execute(request);
        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(body);

//        HttpGet request = new HttpGet(URI);
//        CloseableHttpResponse response = httpClient.execute(request);
//
//        List<Response> responses = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});
//        Stream<Response> stream = responses.stream();
//        responses= stream.filter(value -> value.getUpvotes() != null && Integer.parseInt(value.getUpvotes()) > 0).toList();
//        System.out.println(responses);
    }
}
