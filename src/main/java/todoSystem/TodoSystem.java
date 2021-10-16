package todoSystem;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class stores all system objects such as tasks, projects, and labels.
 */
public class TodoSystem implements Serializable {
    private final HashMap<String, Task> tasks = new HashMap<>();
    private final HashMap<String, Project> projects = new HashMap<>();
    private final HashMap<String, Label> labels = new HashMap<>();

    public TodoSystem() {
        projects.put("Inbox", new Project("Inbox", false));
        labels.put("Starred", new Label("Starred", false));
    }

    public HashMap<String, Task> getTasks() {
        return this.tasks;
    }

    public void addTask(String name, String duedate, String description, Project project){
        this.tasks.put(name, new Task(name, duedate, description, project));
    }

    public void delTask(String name){
        this.tasks.remove(name);}

    public HashMap<String, Project> getProjects() {
        return this.projects;
    }

    public void addProject(String name) {this.projects.put(name,
            new Project(name, true));}

    public void delProjects(String name) {this.projects.remove(name);}

    public HashMap<String, Label> getLabels() {
        return this.labels;
    }

    public void addLab(String name) {this.labels.put(name, new Label(name, true));}

    public void delLab(String name) {this.labels.remove(name);}
}
