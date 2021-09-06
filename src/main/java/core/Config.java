package core;

public class Config {
    public static String globalEnvironment = "pro";
    public static String platform = "web";
    public static int maxRetryTest = 0;


    public static String getEnvironment() {
        globalEnvironment = System.getProperty("environment");
        Log.debug("environment : " + globalEnvironment);
        return globalEnvironment;
    }

    public static String getPlatform() {
        platform = System.getProperty("platform");
        Log.debug("platform : " + platform);
        return platform;
    }

    public static void printLine() {
        System.out.println("---------------------------------------------------------------");
    }

    public static void init(String environment) {

        Log.info("Init Test");
        Config.globalEnvironment = environment;
        Log.info("Global environment : " + environment);
        String sysRetryTest = System.getProperty("retry.test");
        if (sysRetryTest != null) {
            maxRetryTest = Integer.valueOf(sysRetryTest);
        }
        printLine();
    }
}
