package commands;

import driver.DataAccessor;
import todoSystem.Task;
import todoSystem.TodoSystem;

public class Redesc implements Executable {

    /**
     * This function executes the redesc command: Change the description of a task from the new time user passed in
     * The task must already exist in the system.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task's description has been updated
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        String name = args[0];
        String newdesc = args[1];

        Task task = todoSystem.getTasks().get(name);
        task.setDescription(newdesc);

        return "Task " + name + "description updated successfully.";
    }
}