import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class FootballResultsParser {

  public static List<Match> parse(String html) {
    List<Match> matches = new ArrayList<>();
    Document doc = Jsoup.parse(html);

    // Example: Adjust the selectors based on the actual HTML structure of misli.com
    Elements matchElements = doc.select(".match-container");
    for (Element matchElement : matchElements) {
      String homeTeam = matchElement.select(".home-team").text();
      String awayTeam = matchElement.select(".away-team").text();
      int homeScore = Integer.parseInt(matchElement.select(".home-score").text());
      int awayScore = Integer.parseInt(matchElement.select(".away-score").text());

      matches.add(new Match(homeTeam, awayTeam, homeScore, awayScore));
    }

    return matches;
  }
}