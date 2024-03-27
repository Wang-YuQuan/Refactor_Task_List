package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;

public class AddProjectAction implements Action {
    private String msg;
    public AddProjectAction() {
        this.msg = "";
    }

    public String excute(String commandLine) {
        String projectName = commandLine.split(" ", 3)[2];
        Projects projects = Projects.instance();
        projects.addProject(projectName);
        return this.msg;
    }
}
