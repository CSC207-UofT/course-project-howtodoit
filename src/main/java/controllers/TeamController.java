package controllers;

import usecases.TeamInputBoundary;

/**
 * This class allows user to create and delete a team, add members and leave team and share admin with others.
 */
public class TeamController {
    /**
     * The singleton instance.
     */
    private static final TeamController instance = new TeamController();
    /**
     * The input boundary.
     */
    private TeamInputBoundary inputBoundary;

    /**
     * Private to prevent anyone else from instantiating.
     */
    private TeamController() {

    }

    /**
     * Provides access to the singleton instance.
     *
     * @return the instance
     */
    public static TeamController getInstance() {
        return instance;
    }

    /**
     * Sets input boundary.
     *
     * @param inputBoundary the use case interface
     */
    public void setInputBoundary(TeamInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Create a new team.
     *
     * @param username current username
     * @param teamName name of the team you want to create
     * @return String indicating success
     * @throws Exception failure to create new team
     */
    public String newTeam(String username, String teamName) throws Exception {
        boolean result = this.inputBoundary.newTeam(username, teamName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "New team created successfully.";
        } else {
            throw new Exception("Failure to create new team.");
        }
    }

    /**
     * Delete a team.
     *
     * @param username current username
     * @param teamName name of the team you want to delete
     * @return String indicating success
     * @throws Exception failure to delete team
     */
    public String delTeam(String username, String teamName) throws Exception {
        boolean result = this.inputBoundary.delTeam(username, teamName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Team deleted successfully.";
        } else {
            throw new Exception("Failure to delete team.");
        }
    }

    /**
     * Change the name of a team.
     *
     * @param username current username
     * @param name1    name of the team you want to change
     * @param name2    the new name
     * @return String indicating success
     * @throws Exception failure to rename team
     */
    public String modTeam(String username, String name1, String name2) throws Exception {
        boolean result = this.inputBoundary.modTeam(username, name1, name2);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Team renamed successfully.";
        } else {
            throw new Exception("Failure to rename team.");
        }
    }

    /**
     * Add a member to a team.
     *
     * @param username current username
     * @param teamName name of the team you want to add a member to
     * @param memName  name of the member you want to add to the team
     * @return String indicating success
     * @throws Exception failure to add member
     */
    public String addMem(String username, String teamName, String memName) throws Exception {
        boolean result = this.inputBoundary.addMem(username, teamName, memName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Member added successfully.";
        } else {
            throw new Exception("Failure to add member.");
        }
    }

    /**
     * Leave a team.
     *
     * @param username current username
     * @param teamName name of the team you want to leave
     * @return String indicating success
     * @throws Exception Failure to leave team
     */
    public String leaveTeam(String username, String teamName) throws Exception {
        boolean result = this.inputBoundary.leaveTeam(username, teamName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Left team successfully.";
        } else {
            throw new Exception("Failure to leave team.");
        }
    }

    /**
     * Promote a member to admin.
     *
     * @param username current username
     * @param teamName name of the team
     * @param memName  name of the member you want to promote
     * @return String indicating success
     * @throws Exception Failure to add admin
     */
    public String addAdmin(String username, String teamName, String memName) throws Exception {
        boolean result = this.inputBoundary.addAdmin(username, teamName, memName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Admin added successfully.";
        } else {
            throw new Exception("Failure to add admin.");
        }
    }
}
