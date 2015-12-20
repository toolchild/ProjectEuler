package problems.problem6;

import problems.LogicBase;

//The sum of the squares of the first ten natural numbers is,
//1^2 + 2^2 + ... + 10^2 = 385
//The square of the sum of the first ten natural numbers is,
//(1 + 2 + ... + 10)^2 = 55^2 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

public class Logic6 extends LogicBase {

  @Override
  public long getResult(Number... numbers) {
    int limit = numbers[0].intValue();
    int sumSquares = getSumSquares(limit);
    int squareSum = getSquareSum(limit);
    int difference = squareSum - sumSquares;
    return difference;
  }

  private int getSumSquares(int limit) {
    int sumSquares = 0;
    for (int i = 1; i <= limit; i++) {
      sumSquares = sumSquares + i * i;
    }
    return sumSquares;
  }

  private int getSquareSum(int limit) {
    int sum = 0;
    for (int i = 0; i <= limit; i++) {
      sum = sum + i;
    }
    int squareSum = sum * sum;
    return squareSum;
  }
}
