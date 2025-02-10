import football._parser.FootballResultsParser;
import de.monticore.ast.ASTNode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;
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

    FootballResultsParser parser = new FootballResultsParser();
    try {
      Optional<ASTNode> result = parser.parse(new StringReader(footballResultsConfig));
      if (result.isPresent()) {
        try {
          FootballResultsVisitor visitor = new FootballResultsVisitor();
          result.get().accept(visitor);
          String htmlContent = visitor.getGeneratedHTML();
          saveToFile("football_results.html", htmlContent);
        } catch (Exception e) {
          LOGGER.log(Level.SEVERE, "Code generation exception: " + e.getMessage(), e);
        }
      } else {
        LOGGER.log(Level.SEVERE, "Parsing failed.");
      }
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Parsing exception: " + e.getMessage(), e);
    }
  }

  private static void saveToFile(String fileName, String content) {
    try (FileWriter fileWriter = new FileWriter(fileName)) {
      fileWriter.write(content);
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Failed to save HTML content to file: " + e.getMessage(), e);
    }
  }
}