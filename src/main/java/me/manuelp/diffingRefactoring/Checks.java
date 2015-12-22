package me.manuelp.diffingRefactoring;

import fj.data.Array;

import java.util.Objects;

public class Checks {
  public static void notNull(Object... xs) {
    if (Array.array(xs).toList().filter(Objects::isNull).isNotEmpty())
      throw new IllegalArgumentException("Values cannot be null!");
  }
}
