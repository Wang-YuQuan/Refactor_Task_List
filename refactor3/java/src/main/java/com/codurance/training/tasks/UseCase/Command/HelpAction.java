package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class HelpAction implements Action {
    private String msg;

    public HelpAction() {
        this.msg = "";
    }
    public String excute(String commandLine) {
        msg += "Commands:\r\n";
        msg += "  show\r\n";
        msg += "  add project <project name>\r\n";
        msg += "  add task <project name> <task description>\r\n";
        msg += "  check <task ID>\r\n";
        msg += "  uncheck <task ID>\r\n";
        msg += "\r\n";
        return msg;
    }
}
