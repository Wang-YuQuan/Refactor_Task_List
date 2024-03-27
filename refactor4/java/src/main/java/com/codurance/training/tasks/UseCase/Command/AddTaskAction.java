package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

public class AddTaskAction implements Action {
    private String msg;
    public AddTaskAction() {
        this.msg = "";
    }

    public String excute(String commandLine) {
        String projectName = commandLine.split(" ", 4)[2];
        String description = commandLine.split(" ", 4)[3];
        Projects projects = Projects.instance();
        int addTaskResult = projects.addTask(projectName, description);
        if (addTaskResult == -1) {
            msg += String.format("Could not find a project with the name \"%s\".", projectName);
            msg += "\r\n";
        }
        return msg;
    }
}
