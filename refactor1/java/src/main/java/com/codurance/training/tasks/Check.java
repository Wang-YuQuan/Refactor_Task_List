package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Check implements Action {
    private String _commandLine;
    private final Map<String, List<Task>> _tasks;
    private final BufferedReader _in;
    private final PrintWriter _out;
    Check(String commandLine, Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        this._commandLine = commandLine;
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void execute() {
        setDone(_commandLine, true);
    }
    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : _tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        _out.printf("Could not find a task with an ID of %d.", id);
        _out.println();
    }
}
