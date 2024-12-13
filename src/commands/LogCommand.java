package commands;

import repository.Repository;

public class LogCommand {
    public void execute() {
        var commitLog = Repository.getCommitLog();
        if (commitLog.isEmpty()) {
            System.out.println("No commits yet.");
        } else {
            for (String commit : commitLog) {
                System.out.println(commit);
            }
        }
    }
}
