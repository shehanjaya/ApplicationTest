/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.test;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author shehan_m
 */
public class LogFileCreator {

    public static Logger logger = getMainLevel3();

    public static Logger getMainLevel3() {
        String errorLogPath;
        errorLogPath = "C:\\CMS_API\\LOGS\\INFO";

        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%m%n";
        layout.setConversionPattern(conversionPattern);

        String filename = "API_INFO.txt";

        filename = errorLogPath + "\\" + filename;

        DailyRollingFileAppender mainL3Appender = new DailyRollingFileAppender();
        mainL3Appender.setFile(filename);
        mainL3Appender.setDatePattern("'.'yyyy-MM-dd");
        mainL3Appender.setLayout(layout);
        mainL3Appender.activateOptions();

        Logger logger3 = Logger.getLogger("mainL3Appender");
        logger3.addAppender(mainL3Appender);
        return logger3;
    }

}
