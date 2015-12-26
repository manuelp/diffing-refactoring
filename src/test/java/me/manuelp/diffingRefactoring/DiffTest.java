package me.manuelp.diffingRefactoring;

import me.manuelp.diffingRefactoring.types.Difference;
import me.manuelp.diffingRefactoring.types.Rating;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static me.manuelp.diffingRefactoring.Diff.diff;
import static me.manuelp.diffingRefactoring.types.Difference.difference;
import static me.manuelp.diffingRefactoring.types.Review.review;
import static me.manuelp.diffingRefactoring.types.Username.username;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiffTest {
  @Test(expected = IllegalArgumentException.class)
  public void diff_should_not_work_on_null_values() {
    diff(null, review("Clean Coder", username("Robert C. Martin"),
                      LocalDateTime.now(), Rating.GOOD, "..."));
  }

  @Test
  public void diff_should_find_a_single_changed_value() {
    List<Difference> differences = diff(
        review("Clean Coder", username("Uncle Bob"), LocalDateTime.now(),
               Rating.GOOD, "..."),
        review("Clean Coder", username("Robert C. Martin"), LocalDateTime.now(),
               Rating.GOOD, "..."));

    assertEquals(1, differences.size());
    assertEquals(difference("Username", "Uncle Bob", "Robert C. Martin"),
                 differences.get(0));
  }

  @Test
  public void diff_should_find_multiple_changed_value() {
    LocalDateTime added = LocalDateTime.now();
    List<Difference> differences = diff(
        review("Clean Coder", username("Robert C. Martin"), added, Rating.GOOD,
               "..."), review("Functional Programming in Java",
                              username("Pierre-Yves Saumont"), added,
                              Rating.GOOD, "..."));

    assertEquals(2, differences.size());
    assertTrue(differences.contains(
        difference("Title", "Clean Coder", "Functional Programming in Java")));
    assertTrue(differences.contains(
        difference("Username", "Robert C. Martin", "Pierre-Yves Saumont")));
  }

  @Test
  public void diff_should_find_new_values() {
    LocalDateTime added = LocalDateTime.now();
    List<Difference> differences = diff(
        review(null, username("Pierre-Yves Saumont"), added, Rating.GOOD, null),
        review("Functional Programming in Java",
               username("Pierre-Yves Saumont"), added, Rating.GOOD, "..."));

    assertEquals(2, differences.size());
    assertTrue(differences.contains(
        difference("Title", "none", "Functional Programming in Java")));
    assertTrue(differences.contains(difference("Text", "none", "...")));
  }
}