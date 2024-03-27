package com.codurance.training.tasks;

import com.codurance.training.tasks.Adapter.Controller.CommandController;
import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskListApp implements Runnable {
    private static final String QUIT = "quit";
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;
    private CommandController commandController;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        CommandController commandController = new CommandController();
        new TaskListApp(in, out, commandController).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer, CommandController commandController) {
        this.in = reader;
        this.out = writer;
        this.commandController = commandController;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        out.print(commandController.excute(commandLine));
    }
}