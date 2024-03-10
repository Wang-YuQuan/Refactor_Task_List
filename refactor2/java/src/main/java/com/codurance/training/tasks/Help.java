package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Help implements Action {
    private String _commandLine;
    private final Map<String, List<Task>> _tasks;
    private final BufferedReader _in;
    private final PrintWriter _out;
    Help(String commandLine, Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        this._commandLine = commandLine;
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void execute() {
        _out.println("Commands:");
        _out.println("  show");
        _out.println("  add project <project name>");
        _out.println("  add task <project name> <task description>");
        _out.println("  check <task ID>");
        _out.println("  uncheck <task ID>");
        _out.println();
    }
}
