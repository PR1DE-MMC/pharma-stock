package tekup.tic1n.moyi.service;

import tekup.tic1n.moyi.model.AbstractEntity;

import java.util.List;
import java.util.Optional;

import static tekup.tic1n.moyi.utils.ConsoleUtil.readInt;
import static tekup.tic1n.moyi.utils.FileSystemUtil.writeObjects;

public abstract class AbstractService<T extends AbstractEntity>{

    protected String fileName;

    protected List<T> items;

    protected AbstractService(List<T> items, String fileName) {
        this.fileName = fileName;
        this.items = items;
    }

    public abstract int create();

    public void deleteById(int t){
        items.removeIf(item -> item.getId() == t);
    }

    public void delete(){
        int id = readInt(">>>Enter the ID of the element you want to remove");
        deleteById(id);
    }

    public List<T> getAll(){
        return items;
    }

    public Optional<T> getById(int id){
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    public void showAll(){
        getAll().forEach(item -> System.out.println(item.toString()));
    }

    public void showCount(){
        System.out.println("There are " + items.size() + " items in the " + fileName);
    }

    public void showById(){
        int id = readInt(">>>Enter the ID of the element you want to see");
        getById(id).ifPresent(item -> System.out.println(item.toString()));
    }

    public int count(){
        return items.size();
    }

    public void destroy(){
        System.out.println("Destroying " + this.getClass().getName());
        System.out.println("Saving Data to " + fileName );
        writeObjects(items, fileName);
    }
}
