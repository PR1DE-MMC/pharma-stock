package tekup.tic1n.moyi.utils;

import tekup.tic1n.moyi.services.singletons.ScannerSingleton;


public class ConsoleUtil {

    private ConsoleUtil(){
        throw new IllegalStateException("Utility class");
    }

    public static String readLine(String message) {
        System.out.print(message);
        return ScannerSingleton.getInstance().nextLine();
    }

    public static int readInt(String message) {
        return Integer.parseInt(readLine(message));
    }

    public static boolean readBoolean(String message) {
        return "y".equalsIgnoreCase(readLine(message));
    }

    public static float readFloat(String message) {
        return Float.parseFloat(readLine(message));
    }

    public static void writeChoices(Object[] objects){
        for (int i = 0; i < objects.length; i++) {
            System.out.println(">>> " + (i+1) + "- " + objects[i].toString());
        }
    }

    public static Object readChoice(Object[] objects){
        int choice = readInt("");
        return objects[choice - 1];
    }

}
