package me.manuelp.diffingRefactoring.types;

import me.manuelp.diffingRefactoring.Checks;
import me.manuelp.diffingRefactoring.rendering.Renderable;

import java.util.Objects;

public class Username implements Renderable {
  private final String name;

  private Username(String name) {this.name = name;}

  public static Username username(String name) {
    Checks.notNull(name);
    return new Username(name);
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Username username = (Username) o;
    return Objects.equals(name, username.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Username{" +
           "name='" + name + '\'' +
           '}';
  }

  @Override
  public String render() {
    return getName();
  }
}
