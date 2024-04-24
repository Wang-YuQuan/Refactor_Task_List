package com.codurance.training.tasks.UseCase.Command;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskLists;
import com.codurance.training.tasks.Entity.Task;

import java.util.List;

public class UnCheckAction implements Action {
    public UnCheckAction() {

    }

    public String excute(String[] commandLine) {
        String msg = "";
        String taskId = commandLine[1];
        msg += setDone(taskId, false);
        return msg;
    }

    private String setDone(String idString, boolean done) {
        String msg = "";
        int id = Integer.parseInt(idString);
        TaskLists taskLists = TaskLists.instance();
        boolean setDoneResult = taskLists.setDone(idString, false);
        if(setDoneResult) {
            return msg;
        }
        msg += String.format("Could not find a task with an ID of %d.", id);
        msg += "\r\n";
        return msg;
    }
}
