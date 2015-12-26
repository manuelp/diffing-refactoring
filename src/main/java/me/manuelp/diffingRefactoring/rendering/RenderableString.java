package me.manuelp.diffingRefactoring.rendering;

import java.util.Objects;

public class RenderableString implements Renderable {
  private final String value;

  private RenderableString(String value) {this.value = value;}

  public static RenderableString renderableString(String value) {
    return value != null ? new RenderableString(value) : null;
  }

  @Override
  public String render() {
    return value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RenderableString that = (RenderableString) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "RenderableString{" +
           "value='" + value + '\'' +
           '}';
  }
}
