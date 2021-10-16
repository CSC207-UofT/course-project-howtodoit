package constants;

import commands.*;

import java.util.HashMap;

public class Commands {
    public static final HashMap<String, Executable> COMMANDS = new HashMap<>();

    /**
     * This class loads all commands.
     */
    public static void loadCommands() {
        COMMANDS.put("newtask", new NewTask());
        COMMANDS.put("rename", new Rename());
        COMMANDS.put("reproj", new Reproj());
        COMMANDS.put("retime", new Retime());
        COMMANDS.put("redesc", new Redesc());
        COMMANDS.put("tasklabadd", new TaskLabAdd());
        COMMANDS.put("tasklabdel", new TaskLabDel());
        COMMANDS.put("newproj", new Newproj());
        COMMANDS.put("modproj", new Modproj());
        COMMANDS.put("delproj", new Delproj());
        COMMANDS.put("viewproj", new Viewproj());
        COMMANDS.put("listproj", new Listproj());
        COMMANDS.put("newlab", new Newlab());
        COMMANDS.put("modlab", new Modlab());
        COMMANDS.put("dellab", new Dellab());
        COMMANDS.put("viewlab", new Viewlab());
        COMMANDS.put("listlab", new Listlab());
        // TODO: add more commands and create those classes!


    }
}
