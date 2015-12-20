package problems.problem9;

import org.apache.log4j.Logger;

import problems.LogicBase;

//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//a2 + b2 = c2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.

public class Logic9 extends LogicBase {

  private static final Logger logConsole = Logger.getLogger("console");

  @Override
  public long getResult(Number... numbers) {
    int result = 0;
    int sum = numbers[0].intValue();
    int steps = 0;
    for (int a = 1; a < sum / 3; a++) {
      for (int b = 2; b < sum / 2; b++) {
        for (int c = 3; c < sum; c++) {
          steps++;
          if (getTripletSum(a, b, c) == sum && isPythagoreanTriplet(a, b, c)) {
            result = getTripletProduct(a, b, c);
            logConsole.debug(a + " * " + b + " * " + c + " = " + result + " steps: " + steps);
            break;
          }
        }
        if (result != 0) {
          break;
        }
      }
      if (result != 0) {
        break;
      }
    }
    return result;
  }

  private int getTripletProduct(int a, int b, int c) {
    return a * b * c;
  }

  private boolean isPythagoreanTriplet(int a, int b, int c) {
    boolean isPythagoreanTriplet = false;
    if (a < b && b < c) {
      int aSquare = a * a;
      int bSquare = b * b;
      int cSquare = c * c;
      if (aSquare + bSquare == cSquare) {
        isPythagoreanTriplet = true;
      }
    }
    return isPythagoreanTriplet;
  }

  private int getTripletSum(int a, int b, int c) {
    return a + b + c;
  }

}
