package me.manuelp.diffingRefactoring.types;

import me.manuelp.diffingRefactoring.Checks;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review {
  private final String        title;
  private final Username      username;
  private final LocalDateTime updated;
  private final Rating        rating;
  private final String        text;

  private Review(String title, Username username, LocalDateTime updated,
                 Rating rating, String text) {
    this.title = title;
    this.username = username;
    this.updated = updated;
    this.rating = rating;
    this.text = text;
  }

  public static Review book(String title, Username username,
                            LocalDateTime added, Rating rating, String text) {
    Checks.notNull(title, username, added, rating, text);
    return new Review(title, username, added, rating, text);
  }

  public String getTitle() {
    return title;
  }

  public Username getUsername() {
    return username;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public Rating getRating() {
    return rating;
  }

  public String getText() {
    return text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Review review = (Review) o;
    return Objects.equals(title, review.title) &&
           Objects.equals(username, review.username) &&
           Objects.equals(updated, review.updated) &&
           rating == review.rating &&
           Objects.equals(text, review.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, username, updated, rating, text);
  }

  @Override
  public String toString() {
    return "Review{" +
           "title='" + title + '\'' +
           ", username=" + username +
           ", updated=" + updated +
           ", rating=" + rating +
           ", text='" + text + '\'' +
           '}';
  }
}
