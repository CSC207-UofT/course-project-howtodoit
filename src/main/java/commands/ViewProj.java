package commands;

import driver.DataAccessor;
import helpers.ChronologicalSort;
import todoSystem.Project;
import todoSystem.Task;
import todoSystem.TodoSystem;

import java.util.HashMap;
import java.util.List;

/**
 * This class renames a project.
 */
public class ViewProj implements Executable{
    /**
     * This function executes the ViewProj command: View all tasks in the project.
     * The project must already exist in the system.
     *
     * @param args a String with length 1, representing the project name.
     * @return a String indicating all tasks in the project has been printed.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem();
        Project project = todoSystem.getProjects().get(args[0]);
        HashMap<String, Task> map= project.getTasks();
        List<Task> list_to_return = ChronologicalSort.tasks_in_ch_order(map);
        for (Task t: list_to_return) {
            System.out.println(t.getName());
        }
        return "All tasks in "+args[0]+" has been printed.";
    }
}