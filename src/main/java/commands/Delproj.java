package commands;
import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.TodoSystem;

public class Delproj implements Executable {
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        String p = args[0];
        Project project = todoSystem.getProjects().get(p);
        Project inbox = todoSystem.getProjects().get("inbox");
        inbox.merge(project.getAll());
        todoSystem.delProjects(p);



        return "Project " + p + "has been removed and all tasks have been added into inbox successfully.";
    }
}
