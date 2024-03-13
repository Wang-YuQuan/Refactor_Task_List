package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ActionFactory {
    private Map<String, List<Task>> _tasks;
    private BufferedReader _in;
    private PrintWriter _out;
    private AddAction addAction;
    public ActionFactory(Map<String, List<Task>> tasks, BufferedReader in, PrintWriter out) {
        _tasks = tasks;
        _in = in;
        _out = out;
        addAction = null;
    }

    public Action CreateAction(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch(command) {
            case "show":
                return new ShowAction(_tasks, _in, _out);
            case "add":
                if(addAction == null) {
                    addAction = new AddAction(_tasks, _in, _out);
                    return addAction;
                }
                return addAction;
            case "check":
                return new CheckAction(_tasks, _in, _out);
            case "uncheck":
                return new UnCheckAction(_tasks, _in, _out);
            case "help":
                return new HelpAction(_tasks, _in, _out);
            default:
                return new ErrorAction(_tasks, _in, _out);
        }
    }
}
