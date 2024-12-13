import commands.InitCommand;
import commands.AddCommand;
import commands.CommitCommand;
import commands.LogCommand;
import commands.PushCommand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to MyGit! Enter your command:");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);

            // Validate the command starts with "git"
            if (!parts[0].equalsIgnoreCase("git")) {
                System.out.println("Unknown command: " + input);
                continue;
            }

            // Get the subcommand (e.g., "init", "add")
            String command = parts.length > 1 ? parts[1] : "";

            // Parse and execute subcommands
            String[] subCommandParts = command.split(" ", 2);
            String subCommand = subCommandParts[0];
            String argument = subCommandParts.length > 1 ? subCommandParts[1] : "";

            switch (subCommand.toLowerCase()) {
                case "init":
                    new InitCommand().execute();
                    break;
                case "add":
                    if (argument.isEmpty()) {
                        System.out.println("Usage: git add <file>");
                    } else {
                        new AddCommand().execute(argument);
                    }
                    break;
                case "commit":
                    if (argument.isEmpty()) {
                        System.out.println("Usage: git commit <message>");
                    } else {
                        new CommitCommand().execute(argument);
                    }
                    break;
                case "log":
                    new LogCommand().execute();
                    break;
                case "push":
                    new PushCommand().execute();
                    break;
                case "exit":
                    System.out.println("Exiting MyGit. Goodbye!");
                    return;
                default:
                    System.out.println("Unknown command: git " + subCommand);
                    break;
            }
        }
    }
}
