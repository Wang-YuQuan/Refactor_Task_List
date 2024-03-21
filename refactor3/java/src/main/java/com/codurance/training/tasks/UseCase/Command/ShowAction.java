package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;

public class ShowAction implements Action {
    private String msg;
    public ShowAction() {
        this.msg = "";
    }
    public String excute(String commandLine) {
        Projects projects = Projects.instance();
        ArrayList<Project> projectList = projects.getAllProject();
        for (Project project : projectList) {
            msg += project.getProjectName() + "\r\n";
            for (Task task : project.getTasks()) {
                msg += String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            msg += "\r\n";
        }
        return msg;
    }
}
