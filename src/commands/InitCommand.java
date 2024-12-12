package commands;

import java.io.File;
import java.io.IOException;

public class InitCommand {
    public void execute() {
        File myGitDir = new File(".mygit");
        if (myGitDir.exists()) {
            System.out.println("Repository already initialized.");
            return;
        }

        if (myGitDir.mkdir()) {
            new File(myGitDir, "commits").mkdir();
            new File(myGitDir, "staging").mkdir();

            try {
                new File(myGitDir, "HEAD").createNewFile();
                new File(myGitDir, "branches.json").createNewFile();
                System.out.println("Initialized a new repository.");
            } catch (IOException e) {
                System.out.println("Error creating repository files: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to create repository.");
        }
    }
}
