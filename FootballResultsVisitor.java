import java.util.List;

public class FootballResultsVisitor {

  private StringBuilder generatedHTML = new StringBuilder();

  public void generateHTML(List<Match> matches) {
    generatedHTML.append("<html>\n<head>\n<title>Football Match Results</title>\n");
    generatedHTML.append("<style>\n");
    generatedHTML.append("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; }\n");
    generatedHTML.append("h1 { color: #333; }\n");
    generatedHTML.append("nav { background-color: #333; padding: 10px; }\n");
    generatedHTML.append("nav a { color: white; margin: 0 10px; text-decoration: none; }\n");
    generatedHTML.append("nav a:hover { text-decoration: underline; }\n");
    generatedHTML.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n");
    generatedHTML.append("th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }\n");
    generatedHTML.append("th { background-color: #f2f2f2; }\n");
    generatedHTML.append("tr:nth-child(even) { background-color: #f9f9f9; }\n");
    generatedHTML.append("footer { background-color: #333; color: white; text-align: center; padding: 10px; position: fixed; bottom: 0; width: 100%; }\n");
    generatedHTML.append("button { background-color: #333; color: white; padding: 10px 20px; border: none; cursor: pointer; }\n");
    generatedHTML.append("button:hover { background-color: #555; }\n");
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

    for (Match match : matches) {
      generatedHTML.append("<tr onmouseover=\"highlightRow(this)\" onmouseout=\"unhighlightRow(this)\">");
      generatedHTML.append("<td>").append(match.getHomeTeam()).append("</td>");
      generatedHTML.append("<td>").append(match.getAwayTeam()).append("</td>");
      generatedHTML.append("<td>").append(match.getHomeScore()).append("</td>");
      generatedHTML.append("<td>").append(match.getAwayScore()).append("</td>");
      generatedHTML.append("</tr>\n");
    }

    generatedHTML.append("</table>\n");
    generatedHTML.append("<footer>\n");
    generatedHTML.append("© 2023 Football Match Results. All rights reserved.\n");
    generatedHTML.append("</footer>\n");
    generatedHTML.append("</body>\n</html>");
  }

  public String getGeneratedHTML() {
    return generatedHTML.toString();
  }
}