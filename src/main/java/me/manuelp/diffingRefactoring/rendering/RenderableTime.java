package me.manuelp.diffingRefactoring.rendering;

import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class RenderableTime implements Renderable {
  private final LocalDateTime value;

  private RenderableTime(LocalDateTime value) {this.value = value;}

  public static RenderableTime renderableTime(LocalDateTime value) {
    return value != null ? new RenderableTime(value) : null;
  }

  @Override
  public String render() {
    return value.format(ISO_DATE_TIME);
  }

  public LocalDateTime getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RenderableTime that = (RenderableTime) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "RenderableTime{" +
           "value=" + value +
           '}';
  }
}
