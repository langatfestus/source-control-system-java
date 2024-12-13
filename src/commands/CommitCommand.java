package commands;

import java.io.File;
import repository.Repository;

public class CommitCommand {
    public void execute(String commitMessage) {
        // Commit logic
        Repository.addToLog(commitMessage);
        System.out.println("Commit created: " + commitMessage);
    }
}
