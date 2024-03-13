package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class CheckAction implements Action {
    private Map<String, List<Task>> _tasks;
    private BufferedReader _in;
    private PrintWriter _out;

    CheckAction(Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void excute(String commandLine) {
        commandLine = commandLine.split(" ", 2)[1];
        setDone(commandLine, true);
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
