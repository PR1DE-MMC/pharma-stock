package tekup.tic1n.moyi.menus;

import tekup.tic1n.moyi.services.impl.ReceiptService;
import tekup.tic1n.moyi.services.singletons.ReceiptServiceSingleton;

public class ReceiptMenu extends AbstractMenu<ReceiptService>{

    public ReceiptMenu() {
        super(ReceiptServiceSingleton.getInstance());
        this.menuMap.put("Show Total", this.service::showTotal);
        this.menuMap.put("Show Sorted", this.service::showSorted);
    }
}
