import de.se_rwth.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import football._parser.FootballResultsParser;

import java.io.StringReader;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class FootballResultsTest {

  @Before
  public void setUp() {
    Log.enableFailQuick(false);
  }

  @Test
  public void testParseFootballResults() throws Exception {
    String footballResultsConfig = "FootballResults {\n" +
        "  Match { HomeTeam: TeamA, AwayTeam: TeamB, HomeScore: 2, AwayScore: 1 },\n" +
        "  Match { HomeTeam: TeamC, AwayTeam: TeamD, HomeScore: 0, AwayScore: 3 }\n" +
        "}";

    FootballResultsParser parser = new FootballResultsParser();
    Optional<de.monticore.ast.ASTNode> result = parser.parse(new StringReader(footballResultsConfig));

    assertTrue(result.isPresent());
    assertTrue(Log.getFindings().isEmpty());

    FootballResultsVisitor visitor = new FootballResultsVisitor();
    result.get().accept(visitor);
    String generatedHTML = visitor.getGeneratedHTML();

    String expectedHTML = "<html>\n<head>\n<title>Football Match Results</title>\n</head>\n<body>\n" +
        "<h1>Football Match Results</h1>\n" +
        "<table border='1'>\n<tr><th>Home Team</th><th>Away Team</th><th>Home Score</th><th>Away Score</th></tr>\n" +
        "<tr><td>TeamA</td><td>TeamB</td><td>2</td><td>1</td></tr>\n" +
        "<tr><td>TeamC</td><td>TeamD</td><td>0</td><td>3</td></tr>\n" +
        "</table>\n</body>\n</html>";

    assertEquals(expectedHTML, generatedHTML);
  }
}