package commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AddCommand {
    public void execute(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        File stagingDir = new File(".mygit/staging");
        File destination = new File(stagingDir, file.getName());

        try {
            Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Staged " + filePath);
        } catch (IOException e) {
            System.out.println("Error staging file: " + e.getMessage());
        }
    }
}
