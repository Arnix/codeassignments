package com.millom.codeassignments;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
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
    int expectClosest = 1; //between 98 and 99
    Assert.assertEquals(expectClosest, numbersGame.closestNumbers());
  }

  @Test
  public void testSortedNumbers() {
      Arrays.sort(NUMBERS);
      ArrayList<Integer> sortedNumbers = new ArrayList<>(Arrays.asList(NUMBERS));
      Assert.assertEquals(numbersGame.getSortedNumbers(), sortedNumbers);
  }

  @Test
  public void testSum() {
    // todo: set correct expectation
    long expectedSum = 346;
    Assert.assertEquals(expectedSum, numbersGame.sum());
  }

  @Test
  public void testSumOfOdds() {
    // todo: set correct expectation
    long expectedSum = 198L;
    Assert.assertEquals(expectedSum, numbersGame.sumOfOdds());
  }

  @Test
  public void testSumOEvens() {
    // todo: set correct expectation
    long expectedSum = 148L;
    Assert.assertEquals(expectedSum, numbersGame.sumOfEvens());
  }

  @Test
  public void testSumOfEvensAndOddsEqualsSum() {
    Assert.assertEquals(numbersGame.sumOfEvens() + numbersGame.sumOfOdds(), numbersGame.sum());

  }

  @Test
  public void testAsyncSum() throws ExecutionException, InterruptedException {
    // todo: set correct expectation
    Long expectedSum = 346L;
    CompletableFuture<Long> longCompletableFuture = numbersGame.sumAsync().toCompletableFuture();

    longCompletableFuture.thenAccept(a -> Assert.assertEquals(expectedSum,a)).join();
    longCompletableFuture.get();
  }

  /*
   * If you are unfamiliar with completable futures, there are lots of information available
   * Google is your friend.
   * This is a good one: https://www.baeldung.com/java-completablefuture
   */

  @Test
  public void testAsyncSumOfOdds() throws ExecutionException, InterruptedException {
    Long expectedSum = 198L;
    CountDownLatch latch = new CountDownLatch(1);
    CompletableFuture<Long> sumOfOddsCompletableFuture = numbersGame.sumOfOddsAsync().toCompletableFuture();

    sumOfOddsCompletableFuture.thenAccept(s -> latch.countDown());
    latch.await(1000L,TimeUnit.MILLISECONDS);
      Assert.assertEquals(expectedSum, sumOfOddsCompletableFuture.get());

    // Implementation hint: look at #CompletionStage.thenAccept
    // Also remember to wait for the completion of the test before continuing the test
    // for instance, use a CountdownLatch and wait for it outside
  }

  @Test
  public void testAsyncSumOfEvens() throws ExecutionException, InterruptedException {
    Long expectedSum = 148L;
    CountDownLatch latch = new CountDownLatch(1);
    CompletableFuture<Long> sumOfEvensCompletable = numbersGame.sumOfEvensAsync().toCompletableFuture();

    sumOfEvensCompletable.thenAccept(s -> latch.countDown());
      latch.await(5000L,TimeUnit.MILLISECONDS);

      Assert.assertEquals(expectedSum, sumOfEvensCompletable.get());

    // Implementation hint: look at #CompletionStage.thenAccept
    // Also remember to wait for the completion of the test before continuing the test
    // for instance, use a CountdownLatch and wait for it outside
  }

  @Test
  public void testAsyncSumOfEvensAndOddsEqualsSum() throws ExecutionException, InterruptedException {
    // todo: implement a test that shows that "sumOfEvensAsync() + sumOfOddsAsync == sumAsync()"
    // todo: implement the assertion of the result
    CountDownLatch latch = new CountDownLatch(3);
    CompletableFuture<Long> sumOfAllCompletableFuture = numbersGame.sumAsync().toCompletableFuture();
    CompletableFuture<Long> sumOfEvensCompletableFuture = numbersGame.sumOfEvensAsync().toCompletableFuture();
    CompletableFuture<Long> sumOfOddsCompletableFuture = numbersGame.sumOfOddsAsync().toCompletableFuture();

    sumOfAllCompletableFuture.thenAccept(s -> latch.countDown());
    sumOfEvensCompletableFuture.thenAccept(s -> latch.countDown());
    sumOfOddsCompletableFuture.thenAccept(s -> latch.countDown());

    latch.await(5000L, TimeUnit.MILLISECONDS);
    Assert.assertEquals(sumOfEvensCompletableFuture.get() + sumOfOddsCompletableFuture.get(), sumOfAllCompletableFuture.get().longValue());


    // Implementation hint: see if you can combine the previous three methods in a smart way using
    // the completion stages
    // Also remember to wait for the completion of the test before continuing the test
    // for instance, use a CountdownLatch and wait for it outside
  }
}
