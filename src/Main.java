import commands.InitCommand;
import commands.AddCommand;
import commands.CommitCommand;
import commands.LogCommand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to MyGit! Enter your command:");
        
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;

            switch (command) {
                case "init":
                    new InitCommand().execute();
                    break;
                case "add":
                    if (argument != null) new AddCommand().execute(argument);
                    else System.out.println("Usage: add <file>");
                    break;
                case "commit":
                    if (argument != null) new CommitCommand().execute(argument);
                    else System.out.println("Usage: commit <message>");
                    break;
                case "log":
                    new LogCommand().execute();
                    break;
                case "exit":
                    System.out.println("Exiting MyGit...");
                    return;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }
}
