/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shehan_m
 */
public class JavaApplication2Test {

    /**
     * @param args the command line arguments
     */
    private static final int MYTHREADS = 50;

    public static void main(String args[]) throws Exception {

//        ExecutorService executor = new ThreadPoolExecutor(20, 30, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());            
//            
//        HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
//
//        String[] list = {"http://crunchify.com", "http://yahoo.com", "http://www.ebay.com",
//            "http://www.example.co", "http://bing.com/", "http://techcrunch.com/", "http://mashable.com/",
//            "http://thenextweb.com/", "https://paypal.com", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
//            "http://ebay.co.uk/", "http://google123.co.uk/", "http://wikipedia.org/", "http://google.com", "http://en.wikipedia.org"};
//
//        //with threads.
//        for (int i = 0; i < list.length; i++) {
//
//            try {
//                String url = list[i];
//                Runnable worker = new MyRunnable(url);
//                executor.execute(worker);
//            } catch (Exception ex) {
//                System.out.println("Form main menu ---->>>>>>>>>>>>>");
//            }
//        }
//        executor.shutdown();
//        // Wait until all threads are finish
//        while (!executor.isTerminated()) {
//
//        }
//        System.out.println("\nFinished all threads");
//        ArrayList<String> test = new ArrayList<>();
////        test.add("Shehan");
////        test.add("Mihiranga");
////        test.add("Jayasooriya");
//
//        boolean isInclude = test.contains("Shehan");
//
//        if (isInclude) {
//            System.out.println("Test success");
//        } else {
//            System.out.println("Test fails");
//        }
        try {
            String date = validate("",20,' ');
            System.out.println("-->"+date+"<--");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String validate(String groupNumber, int i, char c) throws Exception {
        String output = null;
        String output1 = null;
        int length = groupNumber.length();
        int padding = i - length;
        char[] test = new char[padding];
        String s = new String(test);
        test.toString();
        output1 = s.replace('\0', c);
        if (c == ' ') {
            output = groupNumber + output1;
        } else if (c == '0') {
            output = output1 + groupNumber;
        } else {

            throw new Exception("Invalid character to replaced");
        }

        return output;
    }

    public static boolean isValidEmail(String theInputString) {

        boolean isValid = true;

        //Set the email pattern string
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

        //Match the given string with the pattern
        Matcher m = p.matcher(theInputString);

        //Check whether match is found
        boolean matchFound = m.matches();

        if (!matchFound) {
            isValid = false;
        }

        return isValid;

    }

    public static boolean isValidDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //To make strict date format validation
        formatter.setLenient(false);
        Date parsedDate = null;
        try {
            parsedDate = formatter.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

//    public static void main(String args[]) throws Exception {
//        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
//        HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
//
//        String[] list = {"http://crunchify.com", "http://yahoo.com", "http://www.ebay.com",
//            "http://www.example.co", "http://bing.com/", "http://techcrunch.com/", "http://mashable.com/",
//            "http://thenextweb.com/", "https://paypal.com", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
//            "http://ebay.co.uk/", "http://google123.co.uk/", "http://wikipedia.org/", "http://google.com", "http://en.wikipedia.org"};
//
//        //with threads.
//        for (int i = 0; i < list.length; i++) {
//
//            try {
//                String url = list[i];
//                Runnable worker = new MyRunnable(url);
//                executor.execute(worker);
//            } catch (Exception ex) {
//                System.out.println("Form main menu ---->>>>>>>>>>>>>");
//            }
//        }
//        executor.shutdown();
//        // Wait until all threads are finish
//        while (!executor.isTerminated()) {
//
//        }
//        System.out.println("\nFinished all threads");
//
//    }
    public static class MyRunnable implements Runnable {

        private final String url;

        MyRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {

            String result = "";
            int code = 200;
            try {

                System.out.println("<<-----String 1 ----->>");
                URL siteURL = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();

                connection.setRequestMethod("GET");
                connection.setConnectTimeout(3000);
                System.out.println("<<-----String 2 ----->>");
                connection.connect();

                code = connection.getResponseCode();
                System.out.println("<<-----String 3 ----->>");
                if (code == 200) {

                    result = "-> Green <-\t" + "Code: " + code;
                    ;
                } else {

                    result = "-> Yellow <-\t" + "Code: " + code;
                }
                System.out.println("<<-----String 4 ----->>");
            } catch (Exception e) {
                result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(JavaApplication2Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            System.out.println(url + "\t\tStatus:" + result + " Current T ;" + Thread.currentThread().getName());
        }
    }

    public static String getFormattedCurrency(String currencyAmount) {
        try {
            double amount = Double.parseDouble(currencyAmount);
            DecimalFormat formatter = new DecimalFormat("#,###.00"); // comma separated currency with two decimal places

//            if (amount > 0) {
//                return formatter.format(amount);
//            } else {
//                return "0.00";
//            }
            if (amount != 0) {
                return formatter.format(amount);
            } else {
                return "0.00";
            }

        } catch (NumberFormatException ex) {
            return currencyAmount;
        }
    }

    public static void printPdf() throws Exception {
        try {
            File statementFile = null;
//            String filename = "C:\\Users\\shehan_m\\JaspersoftWorkspace\\MyReports\\Test_2.jrxml";
            String filename = "D:\\Trainee\\Test_1.jrxml";
//            HashMap parameters = new HashMap();
            HashMap parameters = new HashMap<String, Object>();
            parameters.put("name", "Shehan Communcation");
//            HashMap parameters = new HashMap<String, Object>();
//
//            parameters.put("empId", "JK- OOP");
//            parameters.put("name", "J shehan");
//            parameters.put("company", "NIC New Delhi");
//            parameters.put("desgination", "Java/J2EE Doveloper");
//            parameters.put("salary", "18000 RS");
//            InputStream is = ReportServlet.class.getResourceAsStream(filename);
//            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(filename);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//            JasperPrint print = JasperFillManager.fillReport(filename, parameters);
            OutputStream output = null;
            statementFile = new File("D:\\Trainee\\" + "shehan1_" + new Date().getTime() + ".pdf");
            output = new FileOutputStream(statementFile);
            JasperExportManager.exportReportToPdfStream(print, output);
//            JasperExportManager.exportReportToPdfFile(print, output);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex);
        }
    }

    public static String cardNumberMask(String cardNo) {
        String maskedCardNo = null;

        try {
            if (cardNo == null) {
                return "--";
            }
            int startIndex = 6;
            int endIndex = 12;
            char maskCharacter = '*';

            try {

                String prefix = cardNo.substring(0, startIndex);
                String postfix = cardNo.substring(endIndex, cardNo.length());
                String pattern = new String(new char[endIndex - startIndex]).replace('\0', maskCharacter);
                maskedCardNo = prefix + pattern + postfix;

            } catch (Exception ex) {
                if (endIndex < startIndex) {
//                    errorLog.error("Error Occurd in method cardNumberMask" + System.lineSeparator() + "startIndex should be less than endIndex");
                    return cardNo.substring(0, 6) + new String(new char[12 - 6]).replace('\0', '*') + cardNo.substring(12, cardNo.length());
                } else if (endIndex > cardNo.length()) {
//                    errorLog.error("Error Occurd in method cardNumberMask" + System.lineSeparator() + "endIndex Too Larger");
                    return cardNo.substring(0, 6) + new String(new char[12 - 6]).replace('\0', '*') + cardNo.substring(12, cardNo.length());
                } else {
//                    errorLog.error("Error in Crad Number MAsking Method", ex);
                    return cardNo.substring(0, 6) + new String(new char[12 - 6]).replace('\0', '*') + cardNo.substring(12, cardNo.length());
                }
            }
        } catch (Exception ex) {
//            errorLog.error("Error in Crad Number MAsking Method", ex);
        }
        return maskedCardNo;
    }

    public static void generateGLForPaymentsKnockOff(double paymentAmount, double npInterest, double npOutstanding, double accruedInterest,
            double accruedfees, double accruedOverLimit, double accruedLatePayment) throws Exception {
        List<Double> balanceAfterSetOff = new ArrayList<Double>();
        List<Double> KnockOffList = new ArrayList<Double>();
        try {
            double remainingBalance = 0.0;
            double capitalAmount = 0.0;
            double otherFees = 0.0;

            double remainingNPInterest = 0.0;
            double remainingNPCapital = 0.0;
            double remainingNPOutstanding = 0.0;
            double remainingAccruedInterest = 0.0;
            double remainingAccruedLatePay = 0.0;
            double remainingAccruedOverLimit = 0.0;
            double remainingAccruedOtherFees = 0.0;

            double knocOffNPInterest = 0.0;
            double knocOffNPCapital = 0.0;
            double knocOffNPOutstanding = 0.0;
            double knocOffAccruedInterest = 0.0;
            double knocOffAccruedLatePay = 0.0;
            double knocOffAccruedOverLimit = 0.0;
            double knocOffAccruedOtherFees = 0.0;

            List<Double> paymentKnockOffList = new ArrayList<Double>();

            capitalAmount = npOutstanding - npInterest;
            otherFees = accruedfees - accruedLatePayment - accruedOverLimit;
            //payment knock-off order shoulde same as below
            // 1.NPINTEREST 2.NPCAPITAL 3. ACCRUEDINTEREST 4. ACCRUEDLATEPAYMENT 5. ACCRUEDOVERLIMIT 6. ACCRUEDOTHERFEES
            paymentKnockOffList.add(npInterest);
            paymentKnockOffList.add(capitalAmount);
            paymentKnockOffList.add(accruedInterest);
            paymentKnockOffList.add(accruedLatePayment);
            paymentKnockOffList.add(accruedOverLimit);
            paymentKnockOffList.add(otherFees);

            remainingBalance = paymentAmount;
            boolean isBreak = true;
            for (double amount : paymentKnockOffList) {
                if (isBreak) {
                    if (remainingBalance > amount) {
                        balanceAfterSetOff.add(0.0);
                        KnockOffList.add(amount);
                        remainingBalance -= amount;
                    } else {
                        balanceAfterSetOff.add(amount - remainingBalance);
                        KnockOffList.add(remainingBalance);
                        remainingBalance = 0.0;
                        isBreak = false;
                    }
                } else {
                    balanceAfterSetOff.add(amount);
                    KnockOffList.add(0.0);
                }
            }

            for (int i = 0; i < balanceAfterSetOff.size(); i++) {
                switch (i) {
                    case 0:
                        remainingNPInterest = balanceAfterSetOff.get(i);
                        break;
                    case 1:
                        remainingNPCapital = balanceAfterSetOff.get(i);
                        break;
                    case 2:
                        remainingAccruedInterest = balanceAfterSetOff.get(i);
                        break;
                    case 3:
                        remainingAccruedLatePay = balanceAfterSetOff.get(i);
                        break;
                    case 4:
                        remainingAccruedOverLimit = balanceAfterSetOff.get(i);
                        break;
                    case 5:
                        remainingAccruedOtherFees = balanceAfterSetOff.get(i);
                        break;
                }
            }

            for (int i = 0; i < KnockOffList.size(); i++) {
                switch (i) {
                    case 0:
                        knocOffNPInterest = KnockOffList.get(i
                        );
                        break;
                    case 1:
                        knocOffNPCapital = KnockOffList.get(i);
                        break;
                    case 2:
                        knocOffAccruedInterest = KnockOffList.get(i);
                        break;
                    case 3:
                        knocOffAccruedLatePay = KnockOffList.get(i);
                        break;
                    case 4:
                        knocOffAccruedOverLimit = KnockOffList.get(i);
                        break;
                    case 5:
                        knocOffAccruedOtherFees = KnockOffList.get(i);
                        break;
                }
            }

            remainingNPOutstanding = remainingNPInterest + remainingNPCapital;
            knocOffNPOutstanding = knocOffNPInterest + knocOffNPCapital;

            System.out.println("remainingNPInterest : -->> " + remainingNPInterest);
            System.out.println("remainingNPCapital : -->> " + remainingNPCapital);
            System.out.println("remainingNPOutstanding : -->> " + remainingNPOutstanding);
            System.out.println("remainingAccruedInterest : -->> " + remainingAccruedInterest);
            System.out.println("remainingAccruedLatePay : -->> " + remainingAccruedLatePay);
            System.out.println("remainingAccruedOverLimit : -->> " + remainingAccruedOverLimit);
            System.out.println("remainingAccruedOtherFees : -->> " + remainingAccruedOtherFees);

            System.out.println("\n");

            System.out.println("knocOffNPInterest : -->> " + knocOffNPInterest);
            System.out.println("knocOffNPCapital : -->> " + knocOffNPCapital);
            System.out.println("knocOffNPOutstanding : -->> " + knocOffNPOutstanding);
            System.out.println("knocOffAccruedInterest : -->> " + knocOffAccruedInterest);
            System.out.println("knocOffAccruedLatePay : -->> " + knocOffAccruedLatePay);
            System.out.println("knocOffAccruedOverLimit : -->> " + knocOffAccruedOverLimit);
            System.out.println("knocOffAccruedOtherFees : -->> " + knocOffAccruedOtherFees);

        } catch (Exception ex) {
            throw ex;
        }
    }

}
