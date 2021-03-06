package controllers;

import usecases.ProjectInputBoundary;

/**
 * This class allows user to create, delete, or modify the name of the project.
 */
public class ProjectController {
    /**
     * The singleton instance.
     */
    private static final ProjectController instance = new ProjectController();
    /**
     * The input boundary.
     */
    private ProjectInputBoundary inputBoundary;

    /**
     * Private to prevent anyone else from instantiating.
     */
    private ProjectController() {

    }

    /**
     * Provides access to the singleton instance.
     *
     * @return the instance
     */
    public static ProjectController getInstance() {
        return instance;
    }

    /**
     * Sets input boundary.
     *
     * @param inputBoundary the use case interface
     */
    public void setInputBoundary(ProjectInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Create a new project.
     *
     * @param username current username
     * @param projName name of the new project you want to create
     * @return String indicating success
     * @throws Exception failure to create a new project
     */
    public String newProj(String username, String projName) throws Exception {
        boolean result = this.inputBoundary.newProj(username, projName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "New project created successfully.";
        } else {
            throw new Exception("Failure to create a new project.");
        }
    }

    /**
     * Delete a project, move all its tasks to "General".
     *
     * @param username current username
     * @param projName name of the project you want to delete
     * @return String indicating success
     * @throws Exception failure to delete project
     */
    public String delProj(String username, String projName) throws Exception {
        boolean result = this.inputBoundary.delProj(username, projName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Project deleted successfully.";
        } else {
            throw new Exception("Failure to delete project.");
        }
    }

    /**
     * Change the name of a project.
     *
     * @param username current username
     * @param name1    name of the project you want to change
     * @param name2    the new name
     * @return String indicating success
     * @throws Exception failure to rename project
     */
    public String modProj(String username, String name1, String name2) throws Exception {
        boolean result = this.inputBoundary.modProj(username, name1, name2);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Project renamed successfully.";
        } else {
            throw new Exception("Failure to rename project.");
        }
    }
}
