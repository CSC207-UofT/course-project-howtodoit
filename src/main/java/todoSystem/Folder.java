package todoSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class stores a collection of tasks.
 */
public class Folder implements Serializable {
    private String name;
    private final HashMap<String, Task> tasks = new HashMap<>();
    private boolean renameable;

    public Folder(String name, boolean renameable) {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        this.tasks.put(task.getName(), task);
    }

    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    public int getLength(){return this.tasks.size();}

    public void merge(HashMap<String, Task> map){this.tasks.putAll(map);}

    public HashMap<String, Task> getAll(){return this.tasks;}

    public HashMap<String, Task> getTasks(){return this.tasks;}

    public List<Task> viewTasks() {
        return new ArrayList<>(tasks.values()); // TODO: sort the list in chronological order, maybe use iterator
    }
}
