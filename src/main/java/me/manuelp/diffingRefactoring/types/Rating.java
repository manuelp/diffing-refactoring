package me.manuelp.diffingRefactoring.types;

import me.manuelp.diffingRefactoring.rendering.Renderable;

public enum Rating implements Renderable {
  UGLY, BAD, AVERAGE, GOOD, AWESOME;

  public String render() {
    return this.name();
  }
}
