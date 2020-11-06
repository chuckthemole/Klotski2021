package com.cpt.klotski;

public class OperatingSystem {
    private static String operatingSystem = System.getProperty("os.name").toLowerCase();
    
    public static void checkOS() {
    	System.out.println(operatingSystem);
    }
    
	public static boolean isWindows() {
        return (operatingSystem.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (operatingSystem.indexOf("mac") >= 0);
    }
    
    public static boolean isUnix() {
        return (operatingSystem.indexOf("nix") >= 0 || operatingSystem.indexOf("nux") >= 0 || operatingSystem.indexOf("aix") > 0 );
        
    }
}
