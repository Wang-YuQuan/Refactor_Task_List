package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddAction implements Action {
    private Map<String, List<Task>> _tasks;
    private BufferedReader _in;
    private PrintWriter _out;
    private long _lastId;

    AddAction(Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        _tasks = tasks;
        _in = in;
        _out = out;
        _lastId = 0;
    }
    public void excute(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
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
        return ++_lastId;
    }
}
