package problems;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import settings.IConstants;
import sun.security.provider.certpath.AdjacencyList;

public abstract class ProblemBase {
  private static final Logger logConsole = Logger.getLogger("console");
  private static final Logger mdLogfile = Logger.getLogger("file");

  private static ArrayList<Long> getResultAndProcessingTime(LogicBase logic, Number... numbers) {
    ArrayList<Long> results = new ArrayList<Long>();
    long start = System.nanoTime();
    results.add(logic.getResult(numbers)); // the problems results is in results[0]
    long end = System.nanoTime();
    results.add(end - start);
    return results;
  }
  
  public static double adjustProcessingTime(long processingTime){
    Double adjustedProcessingTime = Long.valueOf(processingTime).doubleValue()/1000000000;
    return adjustedProcessingTime;
  }
  
  public static void print(LogicBase logic, int problemNumber, Number... numbers){
    ArrayList<Long> results = getResultAndProcessingTime(logic, numbers); 
    StringBuilder problemResultString = new StringBuilder();
    problemResultString = problemResultString.append(results.get(0).toString());
    
    while(problemResultString.length()<IConstants._PROBLEM_RESULT_STRING_LENGTH){
      problemResultString.append(' ');
    }
    
    logConsole.info("Problem " + problemNumber + "\t" + problemResultString.toString() + " \t processing time (seconds): "+ String.format("%.12f", adjustProcessingTime(results.get(1))) );
    mdLogfile.info("| " + problemNumber + "|" + problemResultString.toString()+ "|"+ String.format("%.12f", adjustProcessingTime(results.get(1))) + "|");
  }
}
