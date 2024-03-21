package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;

public class UnCheckAction implements Action {
    private String msg;

    public UnCheckAction() {
        this.msg = "";
    }

    public String excute(String commandLine) {
        String taskId = commandLine.split(" ", 2)[1];
        setDone(taskId, false);
        return msg;
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        Projects projects = Projects.instance();
        ArrayList<Project> projectList = projects.getAllProject();
        for (Project project : projectList) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        msg += String.format("Could not find a task with an ID of %d.", id);
        msg += "\r\n";
    }
}
