package tekup.tic1n.moyi.services.singletons;

import tekup.tic1n.moyi.services.impl.StockService;

public class StockServiceSingleton {

    private static StockService instance;
    private StockServiceSingleton() {}

    public static StockService getInstance() {
        if(instance == null) {
            instance = new StockService();
        }
        return instance;
    }
    
}
