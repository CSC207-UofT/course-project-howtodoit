package commands;

import driver.DataAccessor;
import todoSystem.Task;
import todoSystem.TodoSystem;

public class Retime implements Executable {

    /**
     * This function executes the retime command: Change the duedate of a task from the new time user passed in
     * The task must already exist in the system.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task's duedate has been updated
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        String name = args[0];
        String newtime = args[1];

        Task task = todoSystem.getTasks().get(name);
        task.setDueDate(newtime);

        return "Task " + name + "due date updated successfully.";
    }
}
