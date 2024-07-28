package tekup.tic1n.moyi.menu;

import tekup.tic1n.moyi.service.impl.StockService;
import tekup.tic1n.moyi.service.singletons.StockServiceSingleton;

public class StockMenu extends AbstractMenu<StockService>{

    public StockMenu() {
        super(StockServiceSingleton.getInstance());
        this.menuMap.put("Increase Stock", this.service::increaseStock);
        this.menuMap.put("Reduce Stock", this.service::reduceStock);
        this.menuMap.put("Get Medication's Stock", this.service::getAvailableStock);
    }

}
