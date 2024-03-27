package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;

public class AddProjectAction implements Action {
    public AddProjectAction() {

    }

    public String excute(String[] commandLine) {
        String msg = "";
        String projectName = commandLine[2];
        Projects projects = Projects.instance();
        projects.addProject(projectName);
        return msg;
    }
}
