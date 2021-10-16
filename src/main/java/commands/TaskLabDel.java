package commands;

import driver.DataAccessor;
import todoSystem.Label;
import todoSystem.Task;
import todoSystem.TodoSystem;

public class TaskLabDel implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        String t = args[0];
        String l = args[1];

        Task task = todoSystem.getTasks().get(t);
        Label label = todoSystem.getLabels().get(l);
        label.delTask(task);

        return "Task " + t + "has been removed from " + l + "successfully.";
    }
}