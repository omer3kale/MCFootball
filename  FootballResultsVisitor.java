import football._ast.ASTFootballResults;
import football._ast.ASTMatch;
import football._visitor.FootballResultsVisitor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FootballResultsVisitor implements FootballResultsVisitor {

  private static final Logger LOGGER = Logger.getLogger(FootballResultsVisitor.class.getName());
  private StringBuilder generatedHTML = new StringBuilder();

  @Override
  public void visit(ASTFootballResults node) {
    try {
      generatedHTML.append("<html>\n<head>\n<title>Football Match Results</title>\n");
      generatedHTML.append("<style>\n");
      generatedHTML.append("body { font-family: Arial, sans-serif; margin: 20px; }\n");
      generatedHTML.append("h1 { color: #333; }\n");
      generatedHTML.append("nav { background-color: #333; padding: 10px; }\n");
      generatedHTML.append("nav a { color: white; margin: 0 10px; text-decoration: none; }\n");
      generatedHTML.append("nav a:hover { text-decoration: underline; }\n");
      generatedHTML.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n");
      generatedHTML.append("th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }\n");
      generatedHTML.append("th { background-color: #f2f2f2; }\n");
      generatedHTML.append("tr:nth-child(even) { background-color: #f9f9f9; }\n");
      generatedHTML.append("</style>\n");
      generatedHTML.append("<script>\n");
      generatedHTML.append("function highlightRow(row) {\n");
      generatedHTML.append("  row.style.backgroundColor = '#ffff99';\n");
      generatedHTML.append("}\n");
      generatedHTML.append("function unhighlightRow(row) {\n");
      generatedHTML.append("  row.style.backgroundColor = '';\n");
      generatedHTML.append("}\n");
      generatedHTML.append("</script>\n");
      generatedHTML.append("</head>\n<body>\n");
      generatedHTML.append("<nav>\n");
      generatedHTML.append("<a href=\"#home\">Home</a>\n");
      generatedHTML.append("<a href=\"#results\">Results</a>\n");
      generatedHTML.append("<a href=\"#about\">About</a>\n");
      generatedHTML.append("</nav>\n");
      generatedHTML.append("<h1>Football Match Results</h1>\n");
      generatedHTML.append("<table>\n<tr><th>Home Team</th><th>Away Team</th><th>Home Score</th><th>Away Score</th></tr>\n");
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error during HTML generation: " + e.getMessage(), e);
    }
  }

  @Override
  public void visit(ASTMatch node) {
    try {
      generatedHTML.append("<tr onmouseover=\"highlightRow(this)\" onmouseout=\"unhighlightRow(this)\">");
      generatedHTML.append("<td>").append(node.getHomeTeam()).append("</td>");
      generatedHTML.append("<td>").append(node.getAwayTeam()).append("</td>");
      generatedHTML.append("<td>").append(node.getHomeScore()).append("</td>");
      generatedHTML.append("<td>").append(node.getAwayScore()).append("</td>");
      generatedHTML.append("</tr>\n");
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error during HTML generation: " + e.getMessage(), e);
    }
  }

  @Override
  public void endVisit(ASTFootballResults node) {
    try {
      generatedHTML.append("</table>\n</body>\n</html>");
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error during HTML generation: " + e.getMessage(), e);
    }
  }

  public String getGeneratedHTML() {
    return generatedHTML.toString();
  }
}