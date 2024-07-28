package tekup.tic1n.moyi.services.singletons;

import tekup.tic1n.moyi.services.impl.ReceiptService;

public class ReceiptServiceSingleton {

    private static ReceiptService instance;
    private ReceiptServiceSingleton() {}

    public static ReceiptService getInstance() {
        if(instance == null) {
            instance = new ReceiptService();
        }
        return instance;
    }
    
}
