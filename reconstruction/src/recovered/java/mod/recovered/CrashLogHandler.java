package mod.recovered;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class CrashLogHandler implements UncaughtExceptionHandler {
  @Override
  public void uncaughtException(Thread thread, Throwable throwable) {
    String html = "<html>" + stackTrace(throwable);
    html = html.replaceAll("at ", "<br>        at ");
    html += "</html>";
    appendLog("erros.log", html);
    throwable.printStackTrace();
  }

  private String stackTrace(Throwable throwable) {
    StringWriter writer = new StringWriter();
    throwable.printStackTrace(new PrintWriter(writer));
    return writer.toString();
  }

  public static void appendLog(String fileName, String text) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
      writer.write(text);
      writer.close();
    } catch (IOException ignored) {
    }
  }

  private void writeThrowable(Throwable throwable) {
    String currentDirectory = System.getProperty("user.dir");
    File errorFile = new File(currentDirectory + "/erros.log");

    try {
      PrintStream stream = new PrintStream(errorFile);
      throwable.printStackTrace(stream);
      stream.close();
    } catch (FileNotFoundException exception) {
      exception.printStackTrace();
    }
  }

  public static void touchInfoError(String ignored) {
    String currentDirectory = System.getProperty("user.dir");
    new File(currentDirectory + "/infoerro.txt");
  }
}
