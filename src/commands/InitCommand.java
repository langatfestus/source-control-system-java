package commands;

import java.io.File;

public class InitCommand {
    public void execute() {
        File repo = new File(".mygit");
        if (!repo.exists()) {
            if (repo.mkdir()) {
                System.out.println("Repository initialized.");
            } else {
                System.out.println("Failed to initialize repository.");
            }
        } else {
            System.out.println("Repository already initialized.");
        }
    }
}
