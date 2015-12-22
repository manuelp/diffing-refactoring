package me.manuelp.diffingRefactoring.types;

import me.manuelp.diffingRefactoring.Checks;

import java.util.Objects;

public class Difference {
  private final String description, previousValue, currentValue;

  private Difference(String description, String previousValue,
                     String currentValue) {
    this.description = description;
    this.previousValue = previousValue;
    this.currentValue = currentValue;
  }

  public static Difference difference(String description, String previousValue,
                                      String newValue) {
    Checks.notNull(description, previousValue, newValue);
    return new Difference(description, previousValue, newValue);
  }

  public String getDescription() {
    return description;
  }

  public String getPreviousValue() {
    return previousValue;
  }

  public String getCurrentValue() {
    return currentValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Difference that = (Difference) o;
    return Objects.equals(description, that.description) &&
           Objects.equals(previousValue, that.previousValue) &&
           Objects.equals(currentValue, that.currentValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, previousValue, currentValue);
  }

  @Override
  public String toString() {
    return "Difference{" +
           "description='" + description + '\'' +
           ", previousValue='" + previousValue + '\'' +
           ", currentValue='" + currentValue + '\'' +
           '}';
  }
}
