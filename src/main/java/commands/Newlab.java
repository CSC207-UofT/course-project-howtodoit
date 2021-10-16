package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;

public class Newlab implements Executable {

        @Override
        public String execute(DataAccessor dataAccessor, String[] args) {
            TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
            // checkArgs(todoSystem, args); // Check whether arguments are valid

            String label = args[0];
            todoSystem.addLab(label);

            return "Label " + label + "has been added successfully.";
        }
}

