package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Add implements Action {
    private String _commandLine;
    private final Map<String, List<Task>> _tasks;
    private final BufferedReader _in;
    private final PrintWriter _out;
    private long lastId = 0;
    Add(String commandLine, Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        this._commandLine = commandLine;
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void execute() {
        String[] subcommandRest = _commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }
    private void addProject(String name) {
        _tasks.put(name, new ArrayList<Task>());
    }
    private void addTask(String project, String description) {
        List<Task> projectTasks = _tasks.get(project);
        if (projectTasks == null) {
            _out.printf("Could not find a project with the name \"%s\".", project);
            _out.println();
            return;
        }
        projectTasks.add(new Task(nextId(), description, false));
    }
    private long nextId() {
        return ++lastId;
    }
}
