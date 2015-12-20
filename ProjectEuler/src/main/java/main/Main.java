package main;

import org.apache.log4j.Logger;

import problems.LogicBase;
import problems.ProblemPrinter;
import settings.IConstants;

public class Main {
  // private static final Logger logConsole = Logger.getLogger("console");
  private static final Logger mdLogfile = Logger.getLogger("file");
  public static final int UNUSED  = 0;

  public static void main(String[] args) {

    printMdLogfileHeader();
    ProblemPrinter.print(LogicBase.getLogicX(1), 1, 0,IConstants.PROBLEM1_LIMIT, IConstants.PROBLEM1_MULTIPLE_OF_X, IConstants.PROBLEM1_MULTIPLE_OF_Y);
    ProblemPrinter.print(LogicBase.getLogicX(2), 2, IConstants.PROBLEM2_LIMIT);
    ProblemPrinter.print(LogicBase.getLogicX(3), 3, IConstants.PROBLEM3_NUMBER);
    ProblemPrinter.print(LogicBase.getLogicX(4), 4, IConstants.PROBLEM4_LIMIT);
    ProblemPrinter.print(LogicBase.getLogicX(5), 5, IConstants.PROBLEM5_DIVISOR_START, IConstants.PROBLEM5_DIVISOR_END);
    ProblemPrinter.print(LogicBase.getLogicX(6), 6, IConstants.PROBLEM6_LIMIT);
    ProblemPrinter.print(LogicBase.getLogicX(7), 7, IConstants.PROBLEM7_INDEX);
    ProblemPrinter.print(LogicBase.getLogicX(8), 8,IConstants.PROBLEM_8_NUMBER_STRING, IConstants.PROBLEM8_INTERVALL_SIZE);
    ProblemPrinter.print(LogicBase.getLogicX(9), 9, IConstants.PROBLEM9_SUM);
  }

  private static void printMdLogfileHeader() {
    mdLogfile.info("#Project Euler");
    mdLogfile.info("|Problem | Result | Processing Time (seconds)|");
    mdLogfile.info("|---:| ---:| ---:|");
  }
}
