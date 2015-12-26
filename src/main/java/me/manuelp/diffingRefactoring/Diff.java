package me.manuelp.diffingRefactoring;

import fj.F;
import me.manuelp.diffingRefactoring.types.Difference;
import me.manuelp.diffingRefactoring.types.Field;
import me.manuelp.diffingRefactoring.types.Review;

import java.util.List;
import java.util.Objects;

import static fj.data.List.list;
import static me.manuelp.diffingRefactoring.types.Difference.difference;
import static me.manuelp.diffingRefactoring.types.Field.field;

public class Diff {
  public static List<Difference> diff(Review x, Review y) {
    if (x == null || y == null) throw new IllegalArgumentException(
        "Reviews shouldn't be null!");

    fj.data.List<Field<?>> changes = list(
        field("Title", x.getTitle(), y.getTitle()),
        field("Username", x.getUsername(), y.getUsername()),
        field("Updated on", x.getUpdated(), y.getUpdated()),
        field("Rating", x.getRating(), y.getRating()),
        field("Text", x.getText(), y.getText()));

    return changes.filter(isFieldChanged()).map(toDifference()).toJavaList();
  }

  private static F<Field<?>, Difference> toDifference() {
    return f -> difference(f.getDescription(),
                           Utils.formatValue(f.getOldValue()),
                           Utils.formatValue(f.getNewValue()));
  }

  private static F<Field<?>, Boolean> isFieldChanged() {
    return f -> !Objects.equals(f.getOldValue(), f.getNewValue());
  }

}
