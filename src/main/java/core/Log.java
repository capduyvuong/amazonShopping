package core;

import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {
    private static int fileCounter = 0;
    private static BufferedWriter logWriter;
    private static boolean canWriteFile;
    private static String logFolder;
    public static FileWriter fileWriter;
    public static File logFile;
    private static String reportPrefix = "_";

    public static void initLogWriter(String folder, boolean fileAccess) {
        try {
            canWriteFile = fileAccess;
            logFolder = folder;
            if (canWriteFile) {
                createLogFolder();
                File file = new File(
                        logFolder + "test_log_" + fileCounter + ".txt");
                file.createNewFile();
                System.out.println("Create log file : " + file.getAbsolutePath() );
                logFile = file.getAbsoluteFile();
                openLogWriter();
            }
        } catch (Exception e) {
            error("Have error in initialize log writer ! " + e.getMessage());
        }
    }

    public static void openLogWriter() {
        try {
            if (canWriteFile) {
                fileWriter = new FileWriter(logFile);
                logWriter = new BufferedWriter(fileWriter);
            }
        } catch (IOException e) {
            error("Have error in closing log writer ! " + e.getMessage());
        }
    }

    public static void closeLogWriter() {
        try {
            if (canWriteFile) {
                logWriter.close();
            }
        } catch (IOException e) {
            error("Have error in closing log writer ! " + e.getMessage());
        }
    }

    public static void createLogFolder() {
        Date date = new Date();

        logFolder = logFolder + date.toString() + "/";

        File directory = new File(logFolder);

        if (directory.exists()) {
            System.out.println(ANSIColor.YELLOW + "core.Log folder already exists" + ANSIColor.RESET);
        } else {
            directory.mkdirs();
        }
    }

    public static void printRawLog(String content) {
        System.out.println(content);
    }

    public static void tobeOnTop(String content) {
        content = ANSIColor.DARK_BLUE + content + ANSIColor.RESET;
        printLog(content);
    }

    public static void highlight(String content) {
        content = ANSIColor.GREEN + content + ANSIColor.RESET;
        printLog(content);
    }

    public static void error(String content) {
        //Redmine.newIssue(content);
        content = ANSIColor.RED + content + ANSIColor.RESET;
        printLog(content);
    }

    public static void errorAndStop(String content) {
        error(content + " - STOP APP");
        Assert.fail(content + " - STOP APP");
    }

    public static void debug(String content) {
        content = ANSIColor.YELLOW + content + ANSIColor.RESET;
        printLog(content);
    }

    public static void info(String content) {
        printLog(content);
    }

    private static void printLog(String content) {
        Date currentDate = new Date();

        content = currentDate.toString() + " | Thread : "
                + Thread.currentThread().getId() + " | Amazon Shopping : " + content;
        content = unescapeString(content);
        System.out.println(content);
    }

    public static String unescapeString(String st) {

        StringBuilder sb = new StringBuilder(st.length());

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == '\\') {
                char nextChar = (i == st.length() - 1) ? '\\' : st
                        .charAt(i + 1);
                // Octal escape?
                if (nextChar >= '0' && nextChar <= '7') {
                    String code = "" + nextChar;
                    i++;
                    if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                            && st.charAt(i + 1) <= '7') {
                        code += st.charAt(i + 1);
                        i++;
                        if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                                && st.charAt(i + 1) <= '7') {
                            code += st.charAt(i + 1);
                            i++;
                        }
                    }
                    sb.append((char) Integer.parseInt(code, 8));
                    continue;
                }
                switch (nextChar) {
                    case '\\':
                        ch = '\\';
                        break;
                    case 'b':
                        ch = '\b';
                        break;
                    case 'f':
                        ch = '\f';
                        break;
                    case 'n':
                        ch = '\n';
                        break;
                    case 'r':
                        ch = '\r';
                        break;
                    case 't':
                        ch = '\t';
                        break;
                    case '\"':
                        ch = '\"';
                        break;
                    case '\'':
                        ch = '\'';
                        break;
                    // Hex Unicode: u????
                    case 'u':
                        if (i >= st.length() - 5) {
                            ch = 'u';
                            break;
                        }
                        int code = Integer.parseInt(
                                "" + st.charAt(i + 2) + st.charAt(i + 3)
                                        + st.charAt(i + 4) + st.charAt(i + 5), 16);
                        sb.append(Character.toChars(code));
                        i += 5;
                        continue;
                }
                i++;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
