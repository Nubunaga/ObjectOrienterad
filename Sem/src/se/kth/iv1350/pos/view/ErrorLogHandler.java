package se.kth.iv1350.pos.view;

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

    public ErrorLogHandler() throws IOException{
        printFile = new PrintWriter(new FileWriter(FILE_NAME),true);
    }

    public void logError(Exception exception){
        StringBuilder sb = new StringBuilder();
        sb.append(createTime()+newLine);
        sb.append(", Exception has been thrown: " + exception.getMessage());
        printFile.println(sb);
        exception.printStackTrace(printFile);
    }

    private String createTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
