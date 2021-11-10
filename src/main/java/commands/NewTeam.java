package commands;

import driver.DataSaver;
/**
 * This class creates a new team
 */
public class NewTeam implements Executable {
    /**
     * This function executes the newTeam command: create a new team called <name> and join the team automatically
     * as an admin.
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a new team has been created successfully
     */
    @Override
    public String execute(DataSaver dataSaver, String[] args) throws Exception {
        return "";
    }

}