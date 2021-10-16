package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.TodoSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class renames a project.
 */
public class ListProj implements Executable{
    /**
     * This function executes the ListProj command: List all projects in alphabetical order
     * and append "inbox" project in the end.
     * The project must already exist in the system.
     *
     * @param args a String with length of 0, representing user arguments
     * @return a String indicating the project name has been returned.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem();
        Set<String> set = todoSystem.getProjects().keySet();
        set.remove("inbox");
        List<String> list_to_return = new ArrayList<>(set);
        Collections.sort(list_to_return);
        list_to_return.add("inbox");
        for (String s: list_to_return) {
            System.out.println(s);
        }
        return "All projects has been printed in alphabetical order.";
    }
}