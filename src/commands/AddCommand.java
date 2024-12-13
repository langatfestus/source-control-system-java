package commands;

import java.io.File;

public class AddCommand {
    public void execute(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            // Assuming some logic to add to staging
            System.out.println("File added: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}
