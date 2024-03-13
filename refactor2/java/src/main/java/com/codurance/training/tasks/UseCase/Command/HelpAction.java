package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class HelpAction implements Action {
    private Map<String, List<Task>> _tasks;
    private BufferedReader _in;
    private PrintWriter _out;

    HelpAction(Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        _tasks = tasks;
        _in = in;
        _out = out;
    }
    public void excute(String commandLine) {
        _out.println("Commands:");
        _out.println("  show");
        _out.println("  add project <project name>");
        _out.println("  add task <project name> <task description>");
        _out.println("  check <task ID>");
        _out.println("  uncheck <task ID>");
        _out.println();
    }
}
