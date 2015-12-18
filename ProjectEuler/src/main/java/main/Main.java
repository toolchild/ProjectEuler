package main;

import problems.ProblemBase;
import problems.problem1.Logic1;
import problems.problem2.Logic2;
import settings.IConstants;

public class Main {

  public static void main(String[] args) {

    ProblemBase.print(new Logic1(), 1, 0.0, IConstants.PROBLEM1_LIMIT, IConstants.PROBLEM1_MULTIPLE_OF_X, IConstants.PROBLEM1_MULTIPLE_OF_Y );;
    ProblemBase.print(new Logic2(), 1, IConstants.PROBLEM2_LIMIT );;
  }

}
