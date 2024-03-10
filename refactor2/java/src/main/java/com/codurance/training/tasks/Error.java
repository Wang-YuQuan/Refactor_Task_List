package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Error implements Action {
    private String _commandLine;
    private final Map<String, List<Task>> _tasks;
    private final BufferedReader _in;
    private final PrintWriter _out;
    Error(String commandLine, Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        this._commandLine = commandLine;
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void execute() {
        _out.printf("I don't know what the command \"%s\" is.", _commandLine);
        _out.println();
    }
}
