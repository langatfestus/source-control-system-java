package repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static final String REPO_DIR = ".mygit";
    private static final String STAGING_DIR = REPO_DIR + "/staging";
    private static final List<String> commitLog = new ArrayList<>();

    public static boolean isInitialized() {
        File repo = new File(REPO_DIR);
        return repo.exists() && repo.isDirectory();
    }

    public static void initialize() {
        File repo = new File(REPO_DIR);
        File staging = new File(STAGING_DIR);

        if (!repo.exists()) {
            if (repo.mkdir()) {
                System.out.println("Repository initialized.");
            } else {
                System.out.println("Failed to initialize repository.");
            }
        } else {
            System.out.println("Repository already initialized.");
        }

        if (!staging.exists() && repo.exists()) {
            if (!staging.mkdir()) {
                System.out.println("Failed to create staging directory.");
            }
        }
    }

    public static void addToLog(String commitMessage) {
        commitLog.add(commitMessage);
    }

    public static List<String> getCommitLog() {
        return new ArrayList<>(commitLog);
    }

    public static String getStagingDir() {
        return STAGING_DIR;
    }
}
