package main;

import org.apache.log4j.Logger;

import problems.ProblemBase;
import problems.problem1.Logic1;
import problems.problem2.Logic2;
import problems.problem3.Logic3;
import problems.problem4.Logic4;
import problems.problem5.Logic5;
import problems.problem6.Logic6;
import settings.IConstants;

public class Main {
//  private static final Logger logConsole = Logger.getLogger("console");
  private static final Logger mdLogfile = Logger.getLogger("file");
  
  public static void main(String[] args) {    
    printMdLogfileHeader();
    ProblemBase.print(new Logic1(), 1, 0.0, IConstants.PROBLEM1_LIMIT, IConstants.PROBLEM1_MULTIPLE_OF_X, IConstants.PROBLEM1_MULTIPLE_OF_Y );
    ProblemBase.print(new Logic2(), 2, IConstants.PROBLEM2_LIMIT );
    ProblemBase.print(new Logic3(), 3, IConstants.PROBLEM3_NUMBER );
    ProblemBase.print(new Logic4(), 4, IConstants.PROBLEM4_LIMIT);
    ProblemBase.print(new Logic5(), 5, IConstants.PROBLEM5_DIVISOR_START, IConstants.PROBLEM5_DIVISOR_END);
    ProblemBase.print(new Logic6(), 6, IConstants.PROBLEM6_LIMIT);
  }

  private static void printMdLogfileHeader() {
    mdLogfile.info("#Project Euler");
    mdLogfile.info("|Problem | Result | Processing Time (nano seconds)|");
    mdLogfile.info("|---:| ---:| ---:|");
  }
}
