package problems;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import settings.ISettings;

public final class ProblemPrinter {
  private static final Logger logConsole = Logger.getLogger("console");
  private static final Logger mdLogfile = Logger.getLogger("file");

  private static ArrayList<Long> getResultAndProcessingTime(LogicBase logic, String problemConstant, Number... numbers) {
    ArrayList<Long> results = new ArrayList<Long>();
    long start = System.nanoTime();
    results.add(logic.getResult(problemConstant, numbers)); // the problems results is in results[0]
    long end = System.nanoTime();
    results.add(end - start);
    return results;
  }

  private static double adjustProcessingTime(long processingTime) {
    Double adjustedProcessingTime = Long.valueOf(processingTime).doubleValue() / ISettings.NANO_SECONDS_TO_SECONDS_FACTOR;
    return adjustedProcessingTime;
  }

  public static void runAndPrintProblem(LogicBase logic, int problemNumber, Number... numbers) {
    runAndPrintProblem(logic, problemNumber, null, numbers);
  }

  /**
   * Runs the problem, collects the result and prints it out.
   * 
   * @param logic
   *          Logic object with which to solve the problem.
   * @param problemNumber
   *          Number of the problem.
   * @param problemConstant
   *          Problem constant as String, null if there is none.
   * @param numbers
   *          Array of Number objects.
   */
  public static void runAndPrintProblem(LogicBase logic, int problemNumber, String problemConstant, Number... numbers) {
    ArrayList<Long> results = getResultAndProcessingTime(logic, problemConstant, numbers);
    StringBuilder problemResultString = new StringBuilder();
    problemResultString = problemResultString.append(results.get(0).toString());
    while (problemResultString.length() < ISettings.PROBLEM_RESULT_STRING_LENGTH) {
      problemResultString.append(' ');
    }

    logConsole.info("Problem " + problemNumber + "\t" + problemResultString.toString() + " \t processing time (seconds): " + String.format("%.9f", adjustProcessingTime(results.get(1))));
    mdLogfile.info("| " + problemNumber + "|" + problemResultString.toString() + "|" + String.format("%.9f", adjustProcessingTime(results.get(1))) + "|");
  }

}
