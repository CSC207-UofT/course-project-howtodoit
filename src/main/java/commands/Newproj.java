package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;



public class Newproj implements Executable {
    /**
     * This function executes the newproj command: create a new project with given params.
     * The projects must not already exist in the system.
     * @param args a list of Strings with length 3, representing user arguments
     * @return a String indicating a new task has been added successfully
     */

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        checkArgs(todoSystem, args); // Check whether arguments are valid

        // User argument is a new project name
        String name = args[0];
        // Create a new project
        todoSystem.addProjects(name);

        return "Project " + name + " created successfully.";
    }

    private void checkArgs(TodoSystem todoSystem, String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Wrong argument length.");
        } else if (todoSystem.getProjects().containsKey(args[0])) {
            throw new Exception("Project " + args[0] + " already exists.");
        }
    }


}
