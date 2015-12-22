package me.manuelp.diffingRefactoring;

import org.junit.Test;

import java.math.BigDecimal;

public class ChecksTest {
  @Test
  public void notNull_should_not_throw_exceptions_without_arguments() {
    Checks.notNull();
  }

  @Test
  public void notNull_should_not_throw_exceptions_if_all_arguments_are_not_null() {
    Checks.notNull("a", 1, new BigDecimal(42));
  }

  @Test(expected = IllegalArgumentException.class)
  public void notNull_should_throw_exception_if_some_arguments_are_null() {
    Checks.notNull(1, null, 3);
  }
}