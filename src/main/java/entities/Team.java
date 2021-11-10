package entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class represents a Team.
 * A team stores a collection of team members and team admins,
 */
public class Team implements Serializable {

    private String name;
    private final HashMap<String, User> members;
    private final HashMap<String, User> admins;

    /**
     * @param name name of the team
     */
    public Team(String name) {
        this.name = name;
        this.members = new HashMap<>();
        this.admins = new HashMap<>();
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, User> getMembers() {
        return this.members;
    }

    public boolean isAdmin(String name) {
        return this.admins.containsKey(name);
    }
}