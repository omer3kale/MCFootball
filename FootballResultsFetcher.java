import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FootballResultsFetcher {

  private static final Logger LOGGER = Logger.getLogger(FootballResultsFetcher.class.getName());

  public static String fetchResults(String url) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();

    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return response.body();
      } else {
        LOGGER.log(Level.SEVERE, "Failed to fetch data. HTTP status code: " + response.statusCode());
        return null;
      }
    } catch (IOException | InterruptedException e) {
      LOGGER.log(Level.SEVERE, "Exception occurred while fetching data: " + e.getMessage(), e);
      return null;
    }
  }
}