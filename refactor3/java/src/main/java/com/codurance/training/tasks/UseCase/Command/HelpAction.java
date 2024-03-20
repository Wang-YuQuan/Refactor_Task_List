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
        msg += "Commands:\n";
        msg += "  show\n";
        msg += "  add project <project name>\n";
        msg += "  add task <project name> <task description>\n";
        msg += "  check <task ID>\n";
        msg += "  uncheck <task ID>\n";
        msg += "\n";
        return msg;
    }
}
