package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Show implements Action {
    private String _commandLine;
    private final Map<String, List<Task>> _tasks;
    private final BufferedReader _in;
    private final PrintWriter _out;
    Show(String commandLine, Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        this._commandLine = commandLine;
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void execute() {
        for (Map.Entry<String, List<Task>> project : _tasks.entrySet()) {
            _out.println(project.getKey());
            for (Task task : project.getValue()) {
                _out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            _out.println();
        }
    }
}
