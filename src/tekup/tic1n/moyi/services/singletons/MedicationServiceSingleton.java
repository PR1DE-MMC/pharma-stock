package tekup.tic1n.moyi.services.singletons;

import tekup.tic1n.moyi.services.impl.MedicationService;

public class MedicationServiceSingleton {
    private static MedicationService instance;
    private MedicationServiceSingleton() {}

    public static MedicationService getInstance() {
        if(instance == null) {
            instance = new MedicationService();
        }
        return instance;
    }
}
