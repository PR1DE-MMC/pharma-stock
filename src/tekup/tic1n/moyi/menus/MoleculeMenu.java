package tekup.tic1n.moyi.menus;

import tekup.tic1n.moyi.services.impl.MoleculeService;
import tekup.tic1n.moyi.services.singletons.MoleculeServiceSingleton;

public class MoleculeMenu extends AbstractMenu<MoleculeService>{

    public MoleculeMenu() {
        super(MoleculeServiceSingleton.getInstance());
    }

}
