package commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class CommitCommand {
    public void execute(String message) {
        File stagingDir = new File(".mygit/staging");
        File[] stagedFiles = stagingDir.listFiles();

        if (stagedFiles == null || stagedFiles.length == 0) {
            System.out.println("No staged changes to commit.");
            return;
        }

        String commitId = UUID.randomUUID().toString();
        File commitDir = new File(".mygit/commits/" + commitId);
        commitDir.mkdir();

        try {
            for (File file : stagedFiles) {
                Files.copy(file.toPath(), new File(commitDir, file.getName()).toPath());
                file.delete(); // Clear staging area
            }

            File branchesFile = new File(".mygit/branches.json");
            FileWriter writer = new FileWriter(branchesFile, true);
            writer.write("{\"commit\": \"" + commitId + "\", \"message\": \"" + message + "\"}\n");
            writer.close();

            System.out.println("Committed changes with ID: " + commitId);
        } catch (IOException e) {
            System.out.println("Error committing changes: " + e.getMessage());
        }
    }
}
