package utils;

public class OSValidator {
	
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static int getOperatingSyatem() {
    	int osType = 0;

        System.out.println(OS);

        if (isWindows()) {
//            System.out.println("This is Windows");
            osType = 1;
        } else if (isMac()) {
//            System.out.println("This is Mac");
            osType = 2;
        } else if (isUnix()) {
//            System.out.println("This is Unix or Linux");
            osType = 3;
        } else if (isSolaris()) {
//            System.out.println("This is Solaris");
            osType = 4;
        } else {
            System.out.println("Your OS is not support!!");
            osType = 0;
            
        }
        return osType;
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

}
