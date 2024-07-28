package tekup.tic1n.moyi.service.singleton;

import tekup.tic1n.moyi.service.impl.DosageService;

public class DosageServiceSingleton {
    private static DosageService instance;
    private DosageServiceSingleton() {}

    public static DosageService getInstance() {
        if(instance == null) {
            instance = new DosageService();
        }
        return instance;
    }
}
