package q19_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

  private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

  public void logCorrectFormat(String logStatement) {
    logger.debug(logStatement);
  }

  public static void main(String[] args) {
    LoggerTest loggerTest = new LoggerTest();
    loggerTest.logCorrectFormat("Hello world");
  }
}
