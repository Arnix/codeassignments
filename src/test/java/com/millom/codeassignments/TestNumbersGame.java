package com.millom.codeassignments;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNumbersGame {

  private NumbersGame numbersGame;
  private static final Integer[] NUMBERS = {3, 9, 50, 15, 99, 7, 98, 65};

  @Before
  public void setup() {
    numbersGame = new NumbersGame(NUMBERS);
  }

  @Test
  public void testClosestNumbers() {
    // todo: set correct expectation
    int expectClosest = 88;
    Assert.assertEquals(expectClosest, numbersGame.closestNumbers());
  }

  @Test
  public void testSortedNumbers() {
    List<Integer> sorted = numbersGame.getSortedNumbers();

    // todo: implement test to verify result
  }

  @Test
  public void testSum() {
    // todo: set correct expectation
    long expectedSum = 88;
    Assert.assertEquals(expectedSum, numbersGame.sum());
  }

  @Test
  public void testSumOfOdds() {
    // todo: set correct expectation
    long expectedSum = 33;
    Assert.assertEquals(expectedSum, numbersGame.sumOfOdds());
  }

  @Test
  public void testSumOEvens() {
    // todo: set correct expectation
    long expectedSum = 44;
    Assert.assertEquals(expectedSum, numbersGame.sumOfEvens());
  }

  @Test
  public void testSumOfEvensAndOddsEqualsSum() {
    // todo: implement a test that shows that "sumOfEvens() + sumOfOdds == sum()"
  }

  @Test
  public void testAsyncSum() throws ExecutionException, InterruptedException {
    // todo: set correct expectation
    Long expectedSum = 100L;
    // todo: implement the assertion of the result
    // Implementation hint: look at #CompletionStage.thenAccept

  }

  @Test
  public void testAsyncSumOfOdds() throws ExecutionException, InterruptedException {
    // todo: set correct expectation
    Long expectedSum = 88L;
    // todo: implement the assertion of the result
    // Implementation hint: look at #CompletionStage.thenAccept
  }

  @Test
  public void testAsyncSumOfEvens() throws ExecutionException, InterruptedException {
    // todo: set correct expectation
    Long expectedSum = 88L;
    // todo: implement the assertion of the result
    // Implementation hint: look at #CompletionStage.thenAccept
  }

  @Test
  public void testAsyncSumOfEvensAndOddsEqualsSum() {
    // todo: implement a test that shows that "sumOfEvensAsync() + sumOfOddsAsync == sumAsync()"
    // todo: implement the assertion of the result
    // Implementation hint: see if you can combine the previous three methods in a smart way using
    // the completion stages
  }
}
