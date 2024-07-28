package tekup.tic1n.moyi.menu;

import tekup.tic1n.moyi.service.AbstractService;

import java.util.HashMap;

import static tekup.tic1n.moyi.utils.ConsoleUtil.readChoice;
import static tekup.tic1n.moyi.utils.ConsoleUtil.writeChoices;

public abstract class AbstractMenu<T extends AbstractService<?>> {

    protected final HashMap<String, Runnable> menuMap;

    protected T service;

    protected AbstractMenu(T service) {
        this.menuMap = new HashMap<>();
        this.service = service;
        menuMap.put("Create", this.service::create);
        menuMap.put("Show All", this.service::showAll);
        menuMap.put("Show By Id", this.service::showById);
        menuMap.put("Show count", this.service::showCount);
        menuMap.put("Remove By Id", this.service::delete);
    }

    public void showChoices(){
        String[] keys = menuMap.keySet().toArray(new String[0]);
        writeChoices(keys);
        String choice = (String) readChoice(keys);
        menuMap.get(choice).run();
    }

    public void destroy(){
        service.destroy();
    }

}
