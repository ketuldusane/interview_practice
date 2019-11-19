package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
  private Map<String, Integer> log;
  /** Initialize your data structure here. */
  public LoggerRateLimiter() {
    log = new HashMap<>();
  }

  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
   If this method returns false, the message will not be printed.
   The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (timestamp < 0) return false;

    if (log.containsKey(message)) {
      if (timestamp - log.get(message) >= 10) {
        log.put(message, timestamp);
        return true;
      }
    } else {
      log.put(message, timestamp);
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    LoggerRateLimiter loggerRateLimiter = new LoggerRateLimiter();
    loggerRateLimiter.print(loggerRateLimiter.shouldPrintMessage(1, "foo"));
    loggerRateLimiter.print(loggerRateLimiter.shouldPrintMessage(2, "bar"));
    loggerRateLimiter.print(loggerRateLimiter.shouldPrintMessage(3, "foo"));
    loggerRateLimiter.print(loggerRateLimiter.shouldPrintMessage(8, "bar"));
    loggerRateLimiter.print(loggerRateLimiter.shouldPrintMessage(10, "foo"));
    loggerRateLimiter.print(loggerRateLimiter.shouldPrintMessage(11, "foo"));
  }

  public void print(boolean ans) {
    System.out.println(String.valueOf(ans));
  }
}
