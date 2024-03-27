package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.UseCase.Command.*;

public class CommandController {
    public CommandController() {

    }
    public String excute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 3);
        String[] splitRest = commandLine.split(" ");
        String firstCommand = commandRest[0];
        String secondCommand = "";
        if(firstCommand.equals("add")) {
            secondCommand = commandRest[1];
        }
        ActionFactory actionFactory = new ActionFactory();
        Action action = actionFactory.createAction(firstCommand, secondCommand);
        return action.excute(splitRest);
    }
}
