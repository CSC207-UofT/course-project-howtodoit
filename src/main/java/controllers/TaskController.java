package controllers;

import usecases.TaskInputBoundary;

/**
 * This class allows user to create and delete, star and unstar, reset and rename and assign a task to a teammate.
 */
public class TaskController {
    /**
     * The singleton instance.
     */
    private static final TaskController instance = new TaskController();
    /**
     * The input boundary.
     */
    private TaskInputBoundary inputBoundary;

    /**
     * Private to prevent anyone else from instantiating.
     */
    private TaskController() {

    }

    /**
     * Provides access to the singleton instance.
     *
     * @return the instance
     */
    public static TaskController getInstance() {
        return instance;
    }

    /**
     * Sets input boundary.
     *
     * @param inputBoundary the use case interface
     */
    public void setInputBoundary(TaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Create a new task.
     *
     * @param username current username
     * @param taskName name of the new task
     * @param dueDate  due date of the new task
     * @param projName project the new task belongs to
     * @return String indicating success
     * @throws Exception failure to create a new task
     */
    public String newTask(String username, String taskName, String dueDate, String projName) throws Exception {
        boolean result = this.inputBoundary.newTask(username, taskName, dueDate, projName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "New task created successfully.";
        } else {
            throw new Exception("Failure to create a new task.");
        }
    }

    /**
     * Complete a task.
     *
     * @param username current username
     * @param taskName name of the task to complete
     * @return String indicating success
     * @throws Exception failure to delete task
     */
    public String completeTask(String username, String taskName) throws Exception {
        boolean result = this.inputBoundary.completeTask(username, taskName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Task deleted successfully.";
        } else {
            throw new Exception("Failure to delete task.");
        }
    }

    /**
     * Star a task.
     *
     * @param username current username
     * @param taskName name of the task to star
     * @return String indicating success
     * @throws Exception failure to star task
     */
    public String star(String username, String taskName) throws Exception {
        boolean result = this.inputBoundary.star(username, taskName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Task starred successfully.";
        } else {
            throw new Exception("Failure to star task.");
        }
    }

    /**
     * Unstar a task.
     *
     * @param username current username
     * @param taskName name of the task to unstar
     * @return String indicating success
     * @throws Exception failure to unstar task
     */
    public String unstar(String username, String taskName) throws Exception {
        boolean result = this.inputBoundary.unstar(username, taskName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Task unstarred successfully.";
        } else {
            throw new Exception("Failure to unstar task.");
        }
    }

    /**
     * Rename a task.
     *
     * @param username current username
     * @param name1    current name of the task
     * @param name2    new name of the task
     * @return String indicating success
     * @throws Exception failure to rename task
     */
    public String rename(String username, String name1, String name2) throws Exception {
        boolean result = this.inputBoundary.rename(username, name1, name2);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Task renamed successfully.";
        } else {
            throw new Exception("Failure to rename task.");
        }
    }

    /**
     * Reset the due date of a task.
     *
     * @param username current username
     * @param taskName name of the task
     * @param dueDate  new due date of the task
     * @return String indicating success
     * @throws Exception failure to reset task due date
     */
    public String retime(String username, String taskName, String dueDate) throws Exception {
        boolean result = this.inputBoundary.retime(username, taskName, dueDate);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Task due date changed successfully.";
        } else {
            throw new Exception("Failure to change the due date of this task.");
        }
    }

    /**
     * Reset the description of a task.
     *
     * @param username current username
     * @param taskName name of the task
     * @param desc     new description of the task
     * @return String indicating success
     * @throws Exception failure to reset task description
     */
    public String redesc(String username, String taskName, String desc) throws Exception {
        boolean result = this.inputBoundary.redesc(username, taskName, desc);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Task description changed successfully.";
        } else {
            throw new Exception("Failure to change the description of this task.");
        }
    }

    /**
     * Assign a task to a teammate
     *
     * @param username1 current user
     * @param teamName  the name of the team
     * @param username2 the name of the teammate
     * @param taskName  the name of the task
     * @param dueDate   due date of the task
     * @return String indicating success
     * @throws Exception failure to assign task to teammate
     */
    public String assignTask(String username1, String teamName, String username2, String taskName, String dueDate) throws Exception {
        boolean result = this.inputBoundary.assignTask(username1, teamName, username2, taskName, dueDate);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "New task assigned to teammate successfully.";
        } else {
            throw new Exception("Failure to assign task.");
        }
    }
}
