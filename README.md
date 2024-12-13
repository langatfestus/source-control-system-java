#Source Control System

Overview

Source Control System is a simplified version control system implemented in Java. It supports basic commands such as initializing a repository, adding files to staging, committing changes, creating branches, and pushing to a remote repository. The goal is to simulate the behavior of Git in a controlled learning environment.

Features

Repository Management

git init: Initialize a new repository.

Staging Files

git add <filename>: Stage files for the next commit.

Committing Changes

git commit -m "<message>": Commit staged changes with a message.

Branch Management

git branch: List all branches.

git branch <branch-name>: Create a new branch.

Pushing Changes

git push: Push committed changes to the remote repository.

File Structure

SourceControlSystem/
├── src/
│   ├── main/
│   │   └── Main.java
│   ├── commands/
│   │   ├── AddCommand.java
│   │   ├── BranchCommand.java
│   │   ├── CommitCommand.java
│   │   ├── InitCommand.java
│   │   └── PushCommand.java
│   ├── repository/
│   │   └── Repository.java
├── bin/
│   └── (compiled .class files)
└── README.md

Commands

1. git init

Description: Initializes a new repository in the current directory.

Usage:

git init

2. git add <filename>

Description: Stages a file for the next commit.

Usage:

git add file1.txt

3. git commit -m "<message>"

Description: Commits all staged changes with a message.

Usage:

git commit -m "Initial commit"

4. git branch

Description: Lists all branches.

Usage:

git branch

5. git branch <branch-name>

Description: Creates a new branch.

Usage:

git branch feature-xyz

6. git push

Description: Pushes committed changes to the remote repository.

Usage:

git push

How to Run

Setup Java Environment

Install the Java Development Kit (JDK).

Set up JAVA_HOME and add the JDK bin folder to your PATH.

Compile the Project

javac -d bin -sourcepath src src/main/Main.java

Run the Application

java -cp bin main.Main

Use Commands

Once the application starts, you can use commands like git init, git add, etc., to interact with the system.

Limitations

This project is a basic simulation and does not include advanced features like merging or pull requests.

It only supports local repositories with a simulated remote.

Future Enhancements

Add support for file diffing.

Implement merge functionality.

Introduce conflict resolution mechanisms.

Author

Developed by Festus Langat.

---

## Personal Reflections

### What do you love most about computing?
I love the limitless possibilities that computing offers to solve problems, automate tasks, and create innovative solutions that impact people’s lives positively.

### If you could meet any scientist or engineer who died before A.D. 2000, whom would you choose, and why?
I would choose Alan Turing. He laid the foundation for modern computing and artificial intelligence. Meeting him would provide insights into his thought process and vision for the future of technology.
