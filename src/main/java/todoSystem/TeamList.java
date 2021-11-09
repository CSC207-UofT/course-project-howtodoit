package todoSystem;

import java.util.HashMap;

/**
 * This class represents a TeamList.
 * A TeamList stores a collection of teams,
 */
public class TeamList {
    private static final TeamList instance = new TeamList();

    private HashMap<String, Team> teams;

    public static TeamList getInstance() {
        return instance;
    }
    public HashMap<String, Team> getTeams() {
        return this.teams;
    }

    public Team getTeam(String name) {
        return this.teams.get(name);
    }

    public void addTeam(Team team) {
        this.teams.put(team.getName(), team);
    }

    public void delTeam(Team team) {
        this.teams.remove(team.getName());
    }
}
