package me.manuelp.diffingRefactoring.types;

import me.manuelp.diffingRefactoring.Checks;

import java.util.Objects;

public class Field<T> {
  private final String description;
  private final T      oldValue, newValue;

  private Field(String description, T oldValue, T newValue) {
    this.description = description;
    this.oldValue = oldValue;
    this.newValue = newValue;
  }

  public static <T> Field<T> field(String name, T oldValue, T newValue) {
    Checks.notNull(name, oldValue, newValue);
    return new Field<>(name, oldValue, newValue);
  }

  public String getDescription() {
    return description;
  }

  public T getOldValue() {
    return oldValue;
  }

  public T getNewValue() {
    return newValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Field<?> field = (Field<?>) o;
    return Objects.equals(description, field.description) &&
           Objects.equals(oldValue, field.oldValue) &&
           Objects.equals(newValue, field.newValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, oldValue, newValue);
  }

  @Override
  public String toString() {
    return "Field{" +
           "description='" + description + '\'' +
           ", oldValue=" + oldValue +
           ", newValue=" + newValue +
           '}';
  }
}
