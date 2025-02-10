import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class FootballResultsFetcherTest {

  @Test
  public void testFetchResultsWithInvalidUrl() {
    String invalidUrl = "http://invalid.url";
    String result = FootballResultsFetcher.fetchResults(invalidUrl);
    assertNull(result);
  }

  @Test
  public void testFetchResultsWithValidUrl() {
    String validUrl = "https://www.misli.com/"; // Replace with a valid URL for testing
    String result = FootballResultsFetcher.fetchResults(validUrl);
    assertNotNull(result);
  }
}