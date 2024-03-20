package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;

public class AddProjectAction implements Action {
    private String msg;
    public AddProjectAction() {
        this.msg = "";
    }

    public String excute(String commandLine) {
        String projectName = commandLine.split(" ", 2)[1];
        Projects projects = Projects.instance();
        Project project = projects.getProject(projectName);
        if(project == null) {
            projects.addProject(projectName);
        }
        return this.msg;
    }
}
