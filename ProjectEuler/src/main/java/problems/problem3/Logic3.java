package problems.problem3;

import org.apache.log4j.Logger;

import problems.LogicBase;

//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

public class Logic3 extends LogicBase {

  private static final Logger logConsole = Logger.getLogger("console");

  @Override
  public int getResult(Number... numbers) {
    int result = getLargestPrimefactor(numbers[0].longValue());
    return result;
  }

  private int getLargestPrimefactor(long number) {
    int result = 0;
    for (int i = 2; i <= number; i++) {
      if (number % i == 0) {
        number = number / i;
        logConsole.debug(i + " : " + number);
        if (result < i) {
          result = i;
        }
      }
    }
    return result;
  }

}
