package tekup.tic1n.moyi.services.singletons;

import tekup.tic1n.moyi.services.impl.MoleculeService;

public class MoleculeServiceSingleton {

    private static MoleculeService instance;
    private MoleculeServiceSingleton() {}

    public static MoleculeService getInstance() {
        if(instance == null) {
            instance = new MoleculeService();
        }
        return instance;
    }
    
}
