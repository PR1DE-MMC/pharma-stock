package tekup.tic1n.moyi.menus;

import tekup.tic1n.moyi.services.impl.DosageService;
import tekup.tic1n.moyi.services.singletons.DosageServiceSingleton;

public class DosageMenu extends AbstractMenu<DosageService>{

    public DosageMenu(){
        super(DosageServiceSingleton.getInstance());
    }

}
