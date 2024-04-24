package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.TaskLists;

public class AddProjectAction implements Action {
    public AddProjectAction() {

    }

    public String excute(String[] commandLine) {
        String msg = "";
        String projectName = commandLine[2];
        TaskLists taskLists = TaskLists.instance();
        taskLists.addProject(projectName);
        return msg;
    }
}
