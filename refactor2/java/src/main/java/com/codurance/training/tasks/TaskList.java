package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    private long lastId = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
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
        String[] commandRest = commandLine.split(" ", 2);
        Action action = createAction(commandRest[0], commandRest[1]);
        action.execute();
    }

    private Action createAction(String firstCommandLine, String lastCommandLine) {
        switch (firstCommandLine) {
            case "show":
                return new Show(firstCommandLine, tasks, in, out);
            case "add":
                return new Add(lastCommandLine, tasks, in, out);
            case "check":
                return new Check(lastCommandLine, tasks, in, out);
            case "uncheck":
                return new UnCheck(lastCommandLine, tasks, in, out);
            case "help":
                return new Help(firstCommandLine, tasks, in, out);
            default:
                return new Error(firstCommandLine, tasks, in, out);
        }
    }
}
