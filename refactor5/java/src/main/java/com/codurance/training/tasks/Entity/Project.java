package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private String projectName;
    private List<Task> tasks;

    public Project(String projectName, List<Task> tasks) {
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Task> getTasks() {
        List<Task> readOnlyTasks = new ArrayList<>();
        for(Task task : tasks) {
            readOnlyTasks.add(new ReadOnlyTask(task));
        }
        return readOnlyTasks;
    }

    public void Add(Task task) {
        tasks.add(task);
    }

    public int getTaskLength() {
        return tasks.size();
    }

    public void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for(Task task : tasks) {
            if(task.getId() == id) {
                task.setDone(done);
                return;
            }
        }
    }
}
