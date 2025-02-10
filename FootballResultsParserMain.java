import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FootballResultsParserMain {

  private static final Logger LOGGER = Logger.getLogger(FootballResultsParserMain.class.getName());

  public static void main(String[] args) {
    String url = "https://www.misli.com/"; // Actual URL to fetch data
    String footballResultsConfig = FootballResultsFetcher.fetchResults(url);

    if (footballResultsConfig == null) {
      LOGGER.log(Level.SEVERE, "Failed to fetch football match data.");
      return;
    }

    List<Match> matches = FootballResultsParser.parse(footballResultsConfig);
    FootballResultsVisitor visitor = new FootballResultsVisitor();
    visitor.generateHTML(matches);
    String htmlContent = visitor.getGeneratedHTML();
    saveToFile("football_results.html", htmlContent);
  }

  private static void saveToFile(String fileName, String content) {
    try (FileWriter fileWriter = new FileWriter(fileName)) {
      fileWriter.write(content);
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Failed to save HTML content to file: " + e.getMessage(), e);
    }
  }
}