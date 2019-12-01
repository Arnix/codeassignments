package com.millom.codeassignments;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

public class NumbersGame {
  private List<Integer> numbers;

  public NumbersGame(Integer... numbers) {
      this.numbers = Arrays.asList(numbers);
  }

  /**
   * Find closest numbers
   *
   * @return the distance between the two closest numbers in the set,
   * the smallest difference between any element in the set of input values.
   */
  public int closestNumbers() {
    List<Integer> sortedNumbers = this.getSortedNumbers();
    int diff  = Integer.MAX_VALUE;

    for (int i = 0; i<sortedNumbers.size() -1; i++)
        if (sortedNumbers.get(i+1) - sortedNumbers.get(i)<diff){
            diff = sortedNumbers.get(i+1) - sortedNumbers.get(i);
        }
        return diff;
  }

  /**
   * Sort the numbers
   *
   * @return the sorted numbers
   */
  public List<Integer> getSortedNumbers() {
    return numbers.stream().sorted().collect(Collectors.toList());
  }

  /**
   * Sum of the numbers
   * Implementation hit: try to use a stream
   * @return the sum
   */
  public long sum() {
    return numbers.stream().mapToInt(Integer::intValue).sum();
  }

  /**
   * Sum the odd numbers
   * Implementation hit: try to use a stream
   *
   * @return the sum of odd numbers
   */
  public long sumOfOdds() {
      return numbers.stream().filter(number -> number%2!=0).mapToInt(Integer::intValue).sum();
  }

  /**
   * Sum of even numbers
   * Implementation hit: try to use a stream
   *
   * @return the sum of even numbers
   */
  public long sumOfEvens() {
      return numbers.stream().filter(number -> number%2==0).mapToInt(Integer::intValue).sum();
  }

  /**
   * Sum of numbers, async computation
   * @return a completion stage that will deliver the sum
   */
  public CompletionStage<Long> sumAsync(){
    return CompletableFuture.supplyAsync(this::sum);
  }

  /**
   * Sum of even numbers, async computation
   * @return a completion stage that will deliver the sum
   */
  public CompletionStage<Long> sumOfEvensAsync(){
    // todo: implement me
    return CompletableFuture.supplyAsync(this::sumOfEvens);
  }

  /**
   * Sum of odd numbers, async computation.
   * @return a completion stage that will deliver the sum
   */
  public CompletionStage<Long> sumOfOddsAsync(){
    // todo: implement me
    return CompletableFuture.supplyAsync(this::sumOfOdds);
  }
}
