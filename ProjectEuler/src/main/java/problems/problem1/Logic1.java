package problems.problem1;

import java.util.ArrayList;

import problems.LogicBase;

// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.

public class Logic1 extends LogicBase {

  @Override
  public double getResult(Number... numbers) {
    ArrayList<Integer> multiples = getNumbers(numbers[0].intValue(), numbers[1].intValue(), numbers[2].intValue(), numbers[3].intValue());
    double result = addNumbers(multiples);
    return result;
  }

  private int addNumbers(ArrayList<Integer> numbers) {
    int result = 0;
    for (Integer integer : numbers) {
      result = result + integer;
    }
    return result;
  }

  /**
   * Returns an ArrayList of Integer which are multiple of x and y
   * 
   * @param start
   * @param end
   * @param multipleOfX
   *          x
   * @param multipleOfY
   *          y
   * @return
   */

  private ArrayList<Integer> getNumbers(int start, int end, int multipleOfX, int multipleOfY) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int number = start; number < end; number++) {
      if (isMultipleOfXAndY(multipleOfX, multipleOfY, number)) {
        result.add(number);
      }
    }
    return result;
  }

  private boolean isMultipleOfXAndY(int multipleOfX, int multipleOfY, int number) {
    boolean result = false;
    if (number % multipleOfX == 0 || number % multipleOfY == 0) {
      result = true;
    }
    return result;
  }

}
