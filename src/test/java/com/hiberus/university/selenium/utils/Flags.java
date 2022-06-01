package com.hiberus.university.selenium.utils;

public class Flags {
    private static final String BROWSER = "browser";
    private static final String HEADLESS = "headless";

    private static final String browser = System.getProperty(BROWSER) != null ? System.getProperty(BROWSER) : "";
    private static final boolean headless = parseBoolean(System.getProperty(HEADLESS));

    private static Flags instance;
    private static boolean parseBoolean(String booleanStr) {
        booleanStr = booleanStr != null ? booleanStr.toLowerCase().trim() : "false";
        return (booleanStr.equals("true") || booleanStr.equals("false")) && Boolean.parseBoolean(booleanStr);
    }
    private Flags() {
    }

    public static Flags getInstance() {
        if (instance == null)
            instance = new Flags();
        return instance;
    }

    public String getBrowser() {
        return browser;
    }

    public boolean isHeadless() {
        return headless;
    }

}
