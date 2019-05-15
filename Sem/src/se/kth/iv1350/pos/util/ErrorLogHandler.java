/**
 * This class is used to log the <code> Exception </code> cause in a stack trace so an programmer can find
 * the cause of the problem.
 * The following line of code have been inspired by the course book about object
 *  oriented development
 * */

package se.kth.iv1350.pos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ErrorLogHandler {
    private static final String FILE_NAME = "ErrorLog.txt";
    private PrintWriter printFile ;
    private String newLine = System.getProperty("line.separator");

    /**
     * Creates the object to be used to log the file.
     * */
    public ErrorLogHandler() throws IOException{
        printFile = new PrintWriter(new FileWriter(FILE_NAME),true);
    }
    /**
     * Logs the error message to a <code> printStackTrace </code> to be viewed in a log.
     * @param exception                         Containing the <code>Exception</code>
     *                                          being thrown.
     * */
    public void logError(Exception exception){
        StringBuilder sb = new StringBuilder();
        sb.append(createTime()+newLine);
        sb.append(", Exception has been thrown: " + exception.getMessage());
        printFile.println(sb);
        exception.printStackTrace(printFile);
    }
    /**
     * Creates a format that show the current time of the crash.
     * @return the format of time "hour, min,sek".
     * */
    private String createTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
