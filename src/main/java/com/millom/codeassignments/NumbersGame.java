package com.millom.codeassignments;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class NumbersGame {
  // todo: implement holder of input values

  public NumbersGame(Integer... numbers) {
    // todo: implement me
  }

  /**
   * Find closest numbers
   *
   * @return the distance between the two closest numbers in the set,
   * the smallest difference between any element in the set of input values.
   */
  public int closestNumbers() {
    // todo: implement me
    return 0;
  }

  /**
   * Sort the numbers
   *
   * @return the sorted numbers
   */
  public List<Integer> getSortedNumbers() {
    // todo: implement me
    return null;
  }

  /**
   * Sum of the numbers
   * Implementation hit: try to use a stream
   * @return the sum
   */
  public long sum() {
    // todo: implement me
    return 0L;
  }

  /**
   * Sum the odd numbers
   * Implementation hit: try to use a stream
   *
   * @return the sum of odd numbers
   */
  public long sumOfOdds() {
    // todo: implement me
    return 0L;
  }

  /**
   * Sum of even numbers
   * Implementation hit: try to use a stream
   *
   * @return the sum of even numbers
   */
  public long sumOfEvens() {
    // todo: implement me
    return 0L;
  }

  /**
   * Sum of numbers, async computation
   * @return a completion stage that will deliver the sum
   */
  public CompletionStage<Long> sumAsync(){
    // todo: implement me
    return CompletableFuture.supplyAsync(() -> 100L);
  }

  /**
   * Sum of even numbers, async computation
   * @return a completion stage that will deliver the sum
   */
  public CompletionStage<Long> sumOfEvensAsync(){
    // todo: implement me
    return CompletableFuture.supplyAsync(() -> 100L);
  }

  /**
   * Sum of odd numbers, async computation.
   * @return a completion stage that will deliver the sum
   */
  public CompletionStage<Long> sumOfOddsAsync(){
    // todo: implement me
    return CompletableFuture.supplyAsync(() -> 100L);
  }
}
