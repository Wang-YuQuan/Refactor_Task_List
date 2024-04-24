package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskLists;
import com.codurance.training.tasks.Entity.Task;

import java.util.List;

public class ShowAction implements Action {
    public ShowAction() {

    }

    public String excute(String[] commandLine) {
        String msg = "";
        TaskLists taskLists = TaskLists.instance();
        List<Project> projectList = taskLists.getAllProject();
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
