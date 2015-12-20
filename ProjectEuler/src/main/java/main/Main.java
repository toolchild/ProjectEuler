package main;

import org.apache.log4j.Logger;

import problems.ProblemPrinter;
import problems.problem1.Logic1;
import problems.problem2.Logic2;
import problems.problem3.Logic3;
import problems.problem4.Logic4;
import problems.problem5.Logic5;
import problems.problem6.Logic6;
import problems.problem7.Logic7;
import problems.problem8.Logic8;
import problems.problem9.Logic9;
import settings.IConstants;

public class Main {
  // private static final Logger logConsole = Logger.getLogger("console");
  private static final Logger mdLogfile = Logger.getLogger("file");

  public static void main(String[] args) {
    printMdLogfileHeader();
    ProblemPrinter.print(new Logic1(), 1, 0.0, IConstants.PROBLEM1_LIMIT, IConstants.PROBLEM1_MULTIPLE_OF_X, IConstants.PROBLEM1_MULTIPLE_OF_Y);
    ProblemPrinter.print(new Logic2(), 2, IConstants.PROBLEM2_LIMIT);
    ProblemPrinter.print(new Logic3(), 3, IConstants.PROBLEM3_NUMBER);
    ProblemPrinter.print(new Logic4(), 4, IConstants.PROBLEM4_LIMIT);
    ProblemPrinter.print(new Logic5(), 5, IConstants.PROBLEM5_DIVISOR_START, IConstants.PROBLEM5_DIVISOR_END);
    ProblemPrinter.print(new Logic6(), 6, IConstants.PROBLEM6_LIMIT);
    ProblemPrinter.print(new Logic7(), 7, IConstants.PROBLEM7_INDEX);
    ProblemPrinter.print(new Logic8(), 8, IConstants.PROBLEM8_INTERVALL_SIZE);
    ProblemPrinter.print(new Logic9(), 9, IConstants.PROBLEM9_SUM);
  }

  private static void printMdLogfileHeader() {
    mdLogfile.info("#Project Euler");
    mdLogfile.info("|Problem | Result | Processing Time (seconds)|");
    mdLogfile.info("|---:| ---:| ---:|");
  }
}
