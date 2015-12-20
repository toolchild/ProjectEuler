package problems;

import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

public abstract class LogicBase {

  private static final Logger logConsole = Logger.getLogger("console");

  public LogicBase() {
  }

  public abstract long getResult(Number... numbers);
  
  public long getResult(String stringConstant, Number... numbers) {
    long result = 0;
    if (stringConstant == null) {
      result = getResult(numbers);
    } else {
      logConsole.info("getResult(String, Numbers...) called but not implemented in Logic: " + this.getClass().getName());
    }
    return result;
  }

  public static LogicBase getLogicX(int logicNumber) {
    String logicClassName = "problems.problem" + logicNumber + ".Logic" + logicNumber;
    logConsole.debug(logicClassName);
    LogicBase logicObject = null;
    try {
      Class<?> logicClass =  Class.forName(logicClassName);
      Constructor<?> logicConstructor =  logicClass.getConstructor();
      logicObject = (LogicBase) logicConstructor.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return logicObject;
  }

}
