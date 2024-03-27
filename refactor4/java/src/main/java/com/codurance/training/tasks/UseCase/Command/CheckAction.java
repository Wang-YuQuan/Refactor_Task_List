package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class CheckAction implements Action {
    public CheckAction() {

    }

    public String excute(String[] commandLine) {
        String msg = "";
        String taskId = commandLine[1];
        msg += setDone(taskId, true);
        return msg;
    }

    private String setDone(String idString, boolean done) {
        String msg = "";
        int id = Integer.parseInt(idString);
        Projects projects = Projects.instance();
        List<Project> projectList = projects.getAllProject();
        for (Project project : projectList) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return msg;
                }
            }
        }
        msg += String.format("Could not find a task with an ID of %d.", id);
        msg += "\r\n";
        return msg;
    }
}
