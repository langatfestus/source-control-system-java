package commands;

import repository.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PushCommand {
    private static final String REMOTE_DIR = ".mygit/remote";

    public void execute() {
        File stagingDir = new File(Repository.getStagingDir());
        File remoteDir = new File(REMOTE_DIR);

        if (!remoteDir.exists()) {
            if (!remoteDir.mkdirs()) {
                System.out.println("Failed to create remote directory.");
                return;
            }
        }

        File[] stagedFiles = stagingDir.listFiles();
        if (stagedFiles == null || stagedFiles.length == 0) {
            System.out.println("No files to push. Stage files with 'git add' first.");
            return;
        }

        for (File stagedFile : stagedFiles) {
            try {
                File destination = new File(remoteDir, stagedFile.getName());
                Files.copy(stagedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Pushed: " + stagedFile.getName());
            } catch (IOException e) {
                System.out.println("Error pushing file: " + stagedFile.getName());
                e.printStackTrace();
            }
        }

        // Clear the staging directory after pushing
        for (File stagedFile : stagedFiles) {
            if (!stagedFile.delete()) {
                System.out.println("Failed to remove staged file: " + stagedFile.getName());
            }
        }

        System.out.println("Push successful: All files pushed to remote directory.");
    }
}
