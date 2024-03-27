package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTaskAction implements Action {
    public AddTaskAction() {

    }

    public String excute(String[] commandLine) {
        String msg = "";
        List<String> cmd = new ArrayList<String>(Arrays.asList(commandLine));
        String projectName = cmd.get(2);
        cmd.remove("add");
        cmd.remove("task");
        cmd.remove(0);
        String description = String.join(" ", cmd);
        Projects projects = Projects.instance();
        int addTaskResult = projects.addTask(projectName, description);
        if (addTaskResult == -1) {
            msg += String.format("Could not find a project with the name \"%s\".", projectName);
            msg += "\r\n";
        }
        return msg;
    }
}
