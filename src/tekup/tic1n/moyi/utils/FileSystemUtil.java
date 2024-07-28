package tekup.tic1n.moyi.utils;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSystemUtil {

    private FileSystemUtil(){
        throw new IllegalStateException("Utility class");
    }

    public static <T> void writeObjects(List<T> objects, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (T obj : objects) {
                oos.writeObject(obj);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        catch(IOException e) {
            System.out.println("Unable To write to file: " + filename);
        }
    }

    public static <T> List<T> readObjects(String filename, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    T obj = clazz.cast(ois.readObject());
                    result.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        }
        catch(IOException e){
            System.out.println("Unable To read File: " + filename);
        }
        catch(ClassNotFoundException e){
            System.out.println("Unable To find Class: " + clazz.getName());
        }
        return result;
    }

}
