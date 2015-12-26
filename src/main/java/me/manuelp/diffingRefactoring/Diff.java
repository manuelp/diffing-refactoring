package me.manuelp.diffingRefactoring;

import fj.F;
import me.manuelp.diffingRefactoring.rendering.Renderable;
import me.manuelp.diffingRefactoring.types.Difference;
import me.manuelp.diffingRefactoring.types.Field;
import me.manuelp.diffingRefactoring.types.Review;

import java.util.List;
import java.util.Objects;

import static fj.data.List.list;
import static fj.data.Option.fromNull;
import static me.manuelp.diffingRefactoring.rendering.RenderableNone.renderableNone;
import static me.manuelp.diffingRefactoring.rendering.RenderableString.renderableString;
import static me.manuelp.diffingRefactoring.rendering.RenderableTime.renderableTime;
import static me.manuelp.diffingRefactoring.types.Difference.difference;
import static me.manuelp.diffingRefactoring.types.Field.field;

public class Diff {
  public static List<Difference> diff(Review x, Review y) {
    if (x == null || y == null) throw new IllegalArgumentException(
        "Reviews shouldn't be null!");

    fj.data.List<Field<? extends Renderable>> changes = list(
        field("Title", renderableString(x.getTitle()),
              renderableString(y.getTitle())),
        field("Username", x.getUsername(), y.getUsername()),
        field("Updated on", renderableTime(x.getUpdated()),
              renderableTime(y.getUpdated())),
        field("Rating", x.getRating(), y.getRating()),
        field("Text", renderableString(x.getText()),
              renderableString(y.getText())));

    return changes.filter(isFieldChanged()).map(toDifference()).toJavaList();
  }

  private static F<Field<? extends Renderable>, Difference> toDifference() {
    return (Field<? extends Renderable> f) -> {
      Renderable oldValue = fromNull(f.getOldValue()).orSome(renderableNone());
      Renderable newValue = fromNull(f.getNewValue()).orSome(renderableNone());
      return difference(f.getDescription(), oldValue.render(),
                        newValue.render());
    };
  }

  private static F<Field<? extends Renderable>, Boolean> isFieldChanged() {
    return f -> !Objects.equals(f.getOldValue(), f.getNewValue());
  }

}
