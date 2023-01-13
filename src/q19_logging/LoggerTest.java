package q19_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

  private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

  public void logCorrectFormat() {
    logger.debug("stuff={}",23);
    logger.info("things={}", new int[]{9, 8});
  }

  public static void main(String[] args) {
//    System.setProperty("slf4j.simpleLogger.defaultLogLevel", "warn");

    LoggerTest loggerTest = new LoggerTest();
    loggerTest.logCorrectFormat();
    loggerTest.logDifferentLevels();
  }

  private void logDifferentLevels() {
    logger.trace("trace={}", 3);
    logger.debug("debug={}", 34);
    logger.info("info={}", 7);
    logger.warn("warn={}", -90);
    logger.error("error={}", "Stuff happened");
  }
}
