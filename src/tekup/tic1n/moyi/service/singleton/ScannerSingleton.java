package tekup.tic1n.moyi.service.singleton;

import java.util.Scanner;

public class ScannerSingleton {

    private static Scanner instance;
    private ScannerSingleton() {}

    public static Scanner getInstance() {
        if(instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

}
