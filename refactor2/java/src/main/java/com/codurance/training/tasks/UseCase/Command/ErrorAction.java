package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ErrorAction implements Action {
    private Map<String, List<Task>> _tasks;
    private BufferedReader _in;
    private PrintWriter _out;

    ErrorAction(Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void excute(String commandLine) {
        commandLine = commandLine.split(" ", 2)[0];
        _out.printf("I don't know what the command \"%s\" is.", commandLine);
        _out.println();
    }
}
