package com.codurance.training.tasks.UseCase.Command;

public class ErrorAction implements Action {
    private String msg;

    public ErrorAction() {
        this.msg = "";
    }
    public String excute(String commandLine) {
        String command = commandLine.split(" ", 2)[0];
        msg += String.format("I don't know what the command \"%s\" is.", command);
        msg += "\r\n";
        return msg;
    }
}
