package main;

import org.apache.log4j.Logger;

import problems.ProblemBase;
import problems.problem1.Logic1;
import problems.problem2.Logic2;
import settings.IConstants;

public class Main {
  private static final Logger logConsole = Logger.getLogger("console");
  private static final Logger mdLogfile = Logger.getLogger("file");
  
  public static void main(String[] args) {
    mdLogfile.info("#Project Euler");
    mdLogfile.info("|Problem | Result | Processing Time (nano seconds)|");
    mdLogfile.info("|---| ---| ---|");
    ProblemBase.print(new Logic1(), 1, 0.0, IConstants.PROBLEM1_LIMIT, IConstants.PROBLEM1_MULTIPLE_OF_X, IConstants.PROBLEM1_MULTIPLE_OF_Y );;
    ProblemBase.print(new Logic2(), 2, IConstants.PROBLEM2_LIMIT );;
  }

}
