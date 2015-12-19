package problems.problem7;

import java.util.ArrayList;

import problems.LogicBase;

//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//What is the 10 001st prime number?

public class Logic7 extends LogicBase {

  private ArrayList<Integer> primes; // list of primes to check with whether the number is a prime

  @Override
  public long getResult(Number... numbers) {
    int result = getSpecificPrime(numbers[0].intValue());
    return result;
  }

  private int getSpecificPrime(int index) { 
    initPrimesArray();
    int number = 1;
    while (primes.size() < index) {
      number = number + 2;
      boolean isPrime = isPrime(number);
      if (isPrime) {
        primes.add(number); // if a prime is found it is added to primes
      }
    }
    return number;
  }

  private void initPrimesArray() {
    if (primes == null || primes.size() == 0) {
      primes = new ArrayList<Integer>();
      primes.add(2);
    }
  }

  private boolean isPrime(int number) {
    boolean isPrime = true;
    for (Integer prime : primes) {
      if (number % prime == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }
}
