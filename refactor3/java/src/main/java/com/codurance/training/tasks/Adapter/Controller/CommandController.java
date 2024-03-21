package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.UseCase.Command.*;

public class CommandController {
    public CommandController() {

    }
    public String excute(String commandLine) {
        Action action = CreateAction(commandLine);
        return action.excute(commandLine);
    }

    public Action CreateAction(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch(command) {
            case "show":
                return new ShowAction();
            case "add":
                if((commandLine.split(" ", 3)[1]).equals("project")) {
                    return new AddProjectAction();
                }
                else {
                    return new AddTaskAction();
                }
            case "check":
                return new CheckAction();
            case "uncheck":
                return new UnCheckAction();
            case "help":
                return new HelpAction();
            default:

                return new ErrorAction();
        }
    }
}
