package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnCheckAction implements Action {
    private String msg;

    public UnCheckAction() {
        this.msg = "";
    }

    public String excute(String commandLine) {
        String taskId = commandLine.split(" ", 3)[1];
        setDone(commandLine, false);
        return msg;
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        Projects projects = Projects.instance();
        ArrayList<Project> projectList = projects.getAllProject();
        for (Project project : projectList) {
            msg += project.getProjectName() + "\n";
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
            msg += "\n";
        }
        msg += String.format("Could not find a task with an ID of %d.", id);
        msg += "\n";
    }
}
