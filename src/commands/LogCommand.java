package commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class LogCommand {
    public void execute() {
        File branchesFile = new File(".mygit/branches.json");
        if (!branchesFile.exists()) {
            System.out.println("No commit history found.");
            return;
        }

        try {
            List<String> logs = Files.readAllLines(branchesFile.toPath());
            for (String log : logs) {
                System.out.println(log);
            }
        } catch (IOException e) {
            System.out.println("Error reading commit history: " + e.getMessage());
        }
    }
}
