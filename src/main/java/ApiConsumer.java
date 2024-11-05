import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumer {

    private ApiConsumer(){}

    public static String getJsonAsString(String uniformResourceIdentifier) throws IOException, InterruptedException {
        return HttpClient.newHttpClient().send(HttpRequest.newBuilder().uri(URI.create(uniformResourceIdentifier)).build(),
                HttpResponse.BodyHandlers.ofString())
                .body();
    }
}