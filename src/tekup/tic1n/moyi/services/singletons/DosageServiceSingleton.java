package tekup.tic1n.moyi.services.singletons;

import tekup.tic1n.moyi.services.impl.DosageService;

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
