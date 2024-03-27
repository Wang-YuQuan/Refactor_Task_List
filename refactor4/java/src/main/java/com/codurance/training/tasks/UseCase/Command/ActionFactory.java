package com.codurance.training.tasks.UseCase.Command;

public class ActionFactory {
    public ActionFactory() {

    }

    public Action createAction(String firstCommand, String secondCommands) {
        switch(firstCommand) {
            case "show":
                return new ShowAction();
            case "add":
                if(secondCommands.equals("project")) {
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
