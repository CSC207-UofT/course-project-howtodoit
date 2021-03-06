package controllers;

import usecases.UserAccountInputBoundary;

/**
 * This class allows user to change their username and password.
 */
public class UserAccountController {
    /**
     * The singleton instance.
     */
    private static final UserAccountController instance = new UserAccountController();
    /**
     * The input boundary.
     */
    private UserAccountInputBoundary inputBoundary;

    /**
     * Private to prevent anyone else from instantiating.
     */
    private UserAccountController() {

    }

    /**
     * Provides access to the singleton instance.
     *
     * @return the instance
     */
    public static UserAccountController getInstance() {
        return instance;
    }

    /**
     * Sets input boundary.
     *
     * @param inputBoundary the use case interface
     */
    public void setInputBoundary(UserAccountInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Change username.
     *
     * @param username current username
     * @param newName  new username
     * @return String indicating success
     * @throws Exception failure to change username because new username already exists
     */
    public String modUsn(String username, String newName) throws Exception {
        boolean result = this.inputBoundary.modUsn(username, newName);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Username changed successfully.";
        } else {
            throw new Exception("This new username already exists.");
        }
    }

    /**
     * Change password.
     *
     * @param username current username
     * @param pw1      current password
     * @param pw2      new password
     * @return String indicating success
     * @throws Exception failure to change password because current password is incorrect
     */
    public String modPwd(String username, String pw1, String pw2) throws Exception {
        boolean result = this.inputBoundary.modPwd(username, pw1, pw2);
        if (result) {
            DataMemoryController.getInstance().setTimeStamp();
            return "Password changed successfully.";
        } else {
            throw new Exception("Current password incorrect. Failure to change password.");
        }
    }
}
