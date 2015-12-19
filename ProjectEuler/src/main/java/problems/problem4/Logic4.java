package problems.problem4;

import org.apache.log4j.Logger;

import com.sun.xml.internal.ws.util.StringUtils;

import problems.LogicBase;

//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

public class Logic4 extends LogicBase {

  private static final Logger logConsole = Logger.getLogger("console");

  @Override
  public int getResult(Number... numbers) {
    int result = findLargestPalindrome(numbers[0].intValue());
    return result;
  }

  private int findLargestPalindrome(int limit) {
    int palindrome = 0;
    int firstNumber = limit;
    while (firstNumber * limit > palindrome) { // while greatest possible product using firstNumber is still greater than the already found palindrome
      int secondNumber = limit;    
      while (secondNumber * firstNumber > palindrome) { // while the current product is still greater than the already found palindrome
        int product = firstNumber * secondNumber;
        if (product > palindrome && isPalindrome(product)) {
          palindrome = product;
        }
        secondNumber--;
      }      
      firstNumber--;
    }
    return palindrome;
  }

  private boolean isPalindrome(int number) {
    boolean result = false;
    String numberString = String.valueOf(number);
    String numberStringPart1 = numberString.substring(0, numberString.length() / 2);
    String numberStringPart2 = numberString.substring(numberString.length() / 2);

    if (numberString.length() % 2 != 0) {
      numberStringPart2 = numberString.substring((numberString.length() + 1) / 2);
    }

    numberStringPart2 = new StringBuilder().append(numberStringPart2).reverse().toString();
    if (numberStringPart1.equals(numberStringPart2)) {
      result = true;
      logConsole.debug(numberString + " -> " + numberStringPart1 + " = " + numberStringPart2);
    }
    return result;
  }

}
