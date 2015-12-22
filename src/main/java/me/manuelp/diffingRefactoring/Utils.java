package me.manuelp.diffingRefactoring;

import me.manuelp.diffingRefactoring.types.Username;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
  public static String formatValue(Object value) {
    if (value == null) return "none";
    else if (value instanceof String) return (String) value;
    else if (value instanceof Username) return ((Username) value).getName();
    else if (value instanceof LocalDateTime)
      return ((LocalDateTime) value).format(DateTimeFormatter.ISO_DATE_TIME);
    else return value.toString();
  }
}
