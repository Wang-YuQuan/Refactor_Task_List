package com.codurance.training.tasks.UseCase.Command;

public class ErrorAction implements Action {
    public ErrorAction() {

    }
    public String excute(String[] commandLine) {
        String msg = "";
        String command = commandLine[0];
        msg += String.format("I don't know what the command \"%s\" is.", command);
        msg += "\r\n";
        return msg;
    }
}
