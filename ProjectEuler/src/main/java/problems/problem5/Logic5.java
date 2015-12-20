package problems.problem5;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import problems.LogicBase;
import problems.problem3.Logic3;

//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class Logic5 extends LogicBase {

  private static final Logger logConsole = Logger.getLogger("console");

  @Override
  public long getResult(Number... numbers) {
    int result = getSmallestNumberDivisibleByStartToEnd(numbers[0].intValue(), numbers[1].intValue());
    return result;
  }

  private int getSmallestNumberDivisibleByStartToEnd(int start, int end) {
    if (start == end || start < 1) {
      return start;
    }

    int result = 1;
    ArrayList<Integer> divisors = getDivisors(start, end);
    ArrayList<ArrayList<Integer>> primefactorsLists = getPrimefactorsLists(divisors);
    HashMap<Integer, Integer> uniquePrimesCounts = new HashMap<Integer, Integer>();
    for (ArrayList<Integer> primefactorList : primefactorsLists) {
      setUniquePrimesCounts(uniquePrimesCounts, primefactorList);
    }

    for (Integer primeCountKey : uniquePrimesCounts.keySet()) {
      for (int i = 1; i <= uniquePrimesCounts.get(primeCountKey); i++) {
        result = result * primeCountKey;
      }
    }

    logConsole.debug(uniquePrimesCounts.toString());
    return result;
  }

  private void setUniquePrimesCounts(HashMap<Integer, Integer> uniquePrimesCounts, ArrayList<Integer> primefactorList) {
    HashMap<Integer, Integer> uniquePrimesCount = getUniquePrimesCount(primefactorList);
    logConsole.debug(primefactorList.toString() + " : " + uniquePrimesCount.toString());
    for (Integer uniquePrimeKey : uniquePrimesCount.keySet()) {
      if (!uniquePrimesCounts.containsKey(uniquePrimeKey)) {
        uniquePrimesCounts.put(uniquePrimeKey, 1);
      } else if (uniquePrimesCount.get(uniquePrimeKey) > uniquePrimesCounts.get(uniquePrimeKey)) {
        uniquePrimesCounts.put(uniquePrimeKey, uniquePrimesCount.get(uniquePrimeKey));
      }
    }
  }

  private HashMap<Integer, Integer> getUniquePrimesCount(ArrayList<Integer> primefactorList) {
    HashMap<Integer, Integer> uniquePrimesCount = new HashMap<Integer, Integer>();

    for (Integer primefactor : primefactorList) {
      if (uniquePrimesCount.containsKey(primefactor)) {
        uniquePrimesCount.put(primefactor, uniquePrimesCount.get(primefactor) + 1);
      } else {
        uniquePrimesCount.put(primefactor, 1);
      }
    }
    return uniquePrimesCount;
  }

  private ArrayList<Integer> getDivisors(int start, int end) {
    ArrayList<Integer> divisors = new ArrayList<Integer>();
    for (int divisorCandidate = start; divisorCandidate <= end; divisorCandidate++) {
      divisors.add(divisorCandidate);
    }
    logConsole.debug(divisors.toString());
    return divisors;
  }

  private ArrayList<ArrayList<Integer>> getPrimefactorsLists(ArrayList<Integer> divisors) {
    ArrayList<ArrayList<Integer>> primefactorsLists = new ArrayList<ArrayList<Integer>>(); // for one number to be divisible by another, all of the prime factors of the divisor must be present in the prime factorization of the dividend. http://codereview.stackexchange.com/questions/13086/smallest-multiple
    Logic3 logic3 = new Logic3();
    for (Integer divisor : divisors) {
      primefactorsLists.add(logic3.getPrimefactors(divisor));
      logConsole.debug(divisor + " : " + primefactorsLists);
    }
    return primefactorsLists;
  }

}
