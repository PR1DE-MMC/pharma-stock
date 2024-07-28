package tekup.tic1n.moyi.menu;

import tekup.tic1n.moyi.service.impl.DosageService;
import tekup.tic1n.moyi.service.singleton.DosageServiceSingleton;

public class DosageMenu extends AbstractMenu<DosageService>{

    public DosageMenu(){
        super(DosageServiceSingleton.getInstance());
    }

}
