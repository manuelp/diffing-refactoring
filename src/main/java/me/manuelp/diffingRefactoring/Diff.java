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
    if (!Objects.equals(x.getTitle(), y.getTitle())) changes.add(
        difference("Title", Utils.formatValue(x.getTitle()),
                   Utils.formatValue(y.getTitle())));
    if (!Objects.equals(x.getTitle(), y.getTitle())) changes.add(
        difference("Username", Utils.formatValue(x.getUsername()),
                   Utils.formatValue(y.getUsername())));
    if (!Objects.equals(x.getTitle(), y.getTitle())) changes.add(
        difference("Updated on", Utils.formatValue(x.getUpdated()),
                   Utils.formatValue(y.getUpdated())));
    if (!Objects.equals(x.getTitle(), y.getTitle())) changes.add(
        difference("Rating", Utils.formatValue(x.getRating()),
                   Utils.formatValue(y.getRating())));
    if (!Objects.equals(x.getTitle(), y.getTitle())) changes.add(
        difference("Text", Utils.formatValue(x.getText()),
                   Utils.formatValue(y.getText())));
    return changes;
  }
}
