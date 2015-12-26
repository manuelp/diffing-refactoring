package me.manuelp.diffingRefactoring.rendering;

public class RenderableNone implements Renderable {
  public static RenderableNone renderableNone() {
    return new RenderableNone();
  }

  @Override
  public String render() {
    return "none";
  }
}
