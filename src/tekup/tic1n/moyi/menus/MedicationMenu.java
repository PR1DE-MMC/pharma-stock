package tekup.tic1n.moyi.menus;

import tekup.tic1n.moyi.services.impl.MedicationService;
import tekup.tic1n.moyi.services.singletons.MedicationServiceSingleton;

public class MedicationMenu extends AbstractMenu<MedicationService>{

    public MedicationMenu(){
        super(MedicationServiceSingleton.getInstance());
    }

}
