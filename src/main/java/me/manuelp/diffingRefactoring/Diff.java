package me.manuelp.diffingRefactoring;

import me.manuelp.diffingRefactoring.types.Difference;
import me.manuelp.diffingRefactoring.types.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.manuelp.diffingRefactoring.types.Difference.difference;

public class Diff {
  public static List<Difference> diff(Review x, Review y) {
    if (x == null || y == null) throw new IllegalArgumentException(
        "Reviews shouldn't be null!");

    List<Difference> changes = new ArrayList<>();
    compareReviewField("Title", x.getTitle(), y.getTitle(), changes);
    compareReviewField("Username", x.getUsername(), y.getUsername(), changes);
    compareReviewField("Updated on", x.getUpdated(), y.getUpdated(), changes);
    compareReviewField("Rating", x.getRating(), y.getRating(), changes);
    compareReviewField("Text", x.getText(), y.getText(), changes);
    return changes;
  }

  private static <T> void compareReviewField(String description, T oldValue,
                                             T newValue,
                                             List<Difference> changes) {
    if (!Objects.equals(oldValue, newValue)) changes.add(
        difference(description, Utils.formatValue(oldValue),
                   Utils.formatValue(newValue)));
  }

}
